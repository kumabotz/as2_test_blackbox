package com.uia.as2;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uia.as2.devices.XiaoMi;

public class App extends UiAutomatorTestCase {
    // TODO: how to initialize different class on the fly?
    private final XiaoMi mUiDevice;

    public App() {
        mUiDevice = new XiaoMi();
    }

    protected void setUp() throws Exception {
        super.setUp();
        launchApp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        mUiDevice.exitApp();
    }

    void launchApp() throws UiObjectNotFoundException {
        getUiDevice().pressHome();
        new UiObject(new UiSelector().text("AutoSync2 Free")).clickAndWaitForNewWindow();
    }
}