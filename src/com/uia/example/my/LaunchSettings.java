package com.uia.example.my;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class LaunchSettings extends UiAutomatorTestCase {
    public void testDemo() throws UiObjectNotFoundException {
        // simulate a short press on the HOME button
        getUiDevice().pressHome();

        // // we're now in the home screen. Next, we want to simulate
        // // a user bringing up the All Apps screen.
        // // If you use the uiautomatorviewer tool to capture a snapshot
        // // of the Home screen, notice that the All Apps button's
        // // content-description property has a value "Apps". We can
        // // use this property to create a UiSelector to find the button
        // UiObject allAppsButton = new UiObject(
        // new UiSelector().description("Apps"));

        // // simulate a click to bring up the All Apps screen.
        // allAppsButton.clickAndWaitForNewWindow();

        // // in the All Apps screen, the Settings app is located in
        // // the Apps tab. To simulate the user bringing up the Apps tab,
        // // we create a UiSelector to find a tab with the text
        // // label "Apps"
        // UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
        //
        // // simulate a click to enter the Apps tab
        // appsTab.click();

        // // next, in the apps tabs, we can simulate a user swiping until
        // // they come to the Settings app icon. Since the container view
        // // is scrollable, we can use a UiScrollable object
        // UiScrollable appViews = new UiScrollable(
        // new UiSelector().scrollable(true));
        //
        // // set the swiping mode to horizontal (the default is vertical)
        // appViews.setAsHorizontalList();

        // create a UiSelector to find the Settings app and simulate
        // a user click to launch the app
        // UiObject settingsApp = appViews
        // .getChildByText(new UiSelector()
        // .className(android.widget.TextView.class.getName()),
        // "Settings");
        UiObject settingsApp = new UiObject(new UiSelector().text("Settings"));
        settingsApp.clickAndWaitForNewWindow();

        // validate the package name is the expected one
        UiObject settingsValidation = new UiObject(
                new UiSelector().packageName("com.android.settings"));
        assertTrue("Unable to detect Settings", settingsValidation.exists());
    }
}