package com.uia.as2;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class MainApp extends UiAutomatorTestCase {
    public void testLaunch() throws UiObjectNotFoundException {
        getUiDevice().pressHome();
        UiObject testApp = new UiObject(new UiSelector().text("AutoSync2 Free"));
        testApp.clickAndWaitForNewWindow();
        assertTrue(
                "should launch Auto Sync 2",
                new UiObject(new UiSelector()
                        .packageName("com.smallmachine.autosync2")).exists());
    }

    public void testOverview() throws UiObjectNotFoundException {
        UiObject overview = new UiObject(
                new UiSelector()
                        .resourceId("com.smallmachine.autosync2:id/summaryView"));
        assertTrue("should have overview", overview.exists());
        assertEquals("should have overview text",
                "Select one or more options above to begin", overview.getText());
    }

    public void testStatus() throws UiObjectNotFoundException {
        UiObject status = new UiObject(
                new UiSelector()
                        .resourceId("com.smallmachine.autosync2:id/statusView"));
        assertTrue("should have status", status.exists());
        assertEquals("should have status text", "Sync is off", status.getText());
    }

    public void testSyncNow() {
        UiObject syncNow = new UiObject(
                new UiSelector()
                        .resourceId("com.smallmachine.autosync2:id/action_sync_now"));
        assertTrue("should have Sync Now", syncNow.exists());
    }

    public void testAd() {
        UiObject ad = new UiObject(
                new UiSelector()
                        .resourceId("com.smallmachine.autosync2:id/adView"));
        assertTrue("should have ad", ad.exists());
    }

    public void testOptions() throws UiObjectNotFoundException {
        UiScrollable options = new UiScrollable(
                new UiSelector().className("android.widget.ListView"));
        assertEquals("should have 3 sync options", options.getChildCount(), 3);

        testOption(options.getChildByInstance(
                new UiSelector().className("android.widget.LinearLayout"), 0),
                "Mode", "Touch to set a mode to turn on sync");
        testOption(options.getChildByInstance(
                new UiSelector().className("android.widget.LinearLayout"), 1),
                "Interval", "Touch to set how frequent to turn on sync");
        testOption(options.getChildByInstance(
                new UiSelector().className("android.widget.LinearLayout"), 2),
                "Time", "Touch to schedule a time to turn on sync");
    }

    private void testOption(UiObject option, String optionTitle,
            String optionValue) throws UiObjectNotFoundException {
        assertTrue("should have option title",
                option.getChild(new UiSelector().text(optionTitle)).exists());
        assertTrue("should have option value",
                option.getChild(new UiSelector().text(optionValue)).exists());
    }
}