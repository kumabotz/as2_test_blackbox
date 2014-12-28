package com.uia.as2.tests;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uia.as2.tests.devices.Device;
import com.uia.as2.tests.devices.DeviceFactory;

public class Test extends UiAutomatorTestCase {
    private Device mDevice;

    public Test() {
        try {
            // NOTE: this syntax is needed to make it works and i don't know why
            mDevice = DeviceFactory.getDevice(getUiDevice().getInstance().getProductName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        launchApp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        exitApp();
    }

    protected void launchApp() throws UiObjectNotFoundException {
        getUiDevice().pressHome();
        new UiObject(new UiSelector().text("AutoSync2 Free")).clickAndWaitForNewWindow();
    }

    protected void exitApp() throws RemoteException, UiObjectNotFoundException {
        mDevice.exitApp();
    }
}