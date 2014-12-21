package com.uia.as2;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

// TODO: handle device navigation
public class App extends UiAutomatorTestCase {
    protected void setUp() throws Exception {
        super.setUp();
        launchApp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        exitApp();
    }

    void launchApp() throws UiObjectNotFoundException {
        getUiDevice().pressHome();
        new UiObject(new UiSelector().text("AutoSync2 Free")).clickAndWaitForNewWindow();
    }

    void exitApp() throws UiObjectNotFoundException, RemoteException {
        getUiDevice().pressRecentApps();
        new UiObject(new UiSelector().resourceId("com.android.systemui:id/app_thumbnail"))
                .swipeRight(5);
    }
}