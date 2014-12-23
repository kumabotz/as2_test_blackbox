package com.uia.as2;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class SettingsApp extends App {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        new UiObject(new UiSelector().description("More options")).clickAndWaitForNewWindow();
        new UiObject(new UiSelector().text("Settings")).clickAndWaitForNewWindow();
    }

    public void testSmoke() throws UiObjectNotFoundException {
        // app
        assertEquals("should navigate to Setting page", "Settings",
                new UiObject(new UiSelector().resourceId("android:id/action_bar_title")).getText());

        // list
        UiCollection list = new UiCollection(
                new UiSelector().className(android.widget.ListView.class.getName()));
        assertEquals("should have list", "Settings",
                list.getChild(new UiSelector().resourceId("android:id/title")).getText());

        // sync duration
        UiObject durationLayout = list.getChildByText(
                new UiSelector().className(android.widget.RelativeLayout.class.getName()),
                "Sync Duration");
        assertEquals("should have default sync duration", "1 minute",
                durationLayout.getChild(new UiSelector().resourceId("android:id/summary"))
                        .getText());
    }

    public void testUpNavigation() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().resourceId("android:id/up")).clickAndWaitForNewWindow();
        assertEquals("should navigate to Main page", "AutoSync2 Free", new UiObject(
                new UiSelector().resourceId("android:id/action_bar_title")).getText());
    }
}