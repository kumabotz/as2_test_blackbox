package com.uia.as2;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uia.as2.devices.Device;

public class App extends UiAutomatorTestCase {
    private Device mDevice;

    public App() {
        try {
            mDevice = (Device) Class.forName(getDeviceImplClass()).newInstance();
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
        mDevice.exitApp();
    }

    void launchApp() throws UiObjectNotFoundException {
        getUiDevice().pressHome();
        new UiObject(new UiSelector().text("AutoSync2 Free")).clickAndWaitForNewWindow();
    }

    String getDeviceImplClass() {
        // NOTE: this syntax is needed to make it works and i don't know why
        String productName = getUiDevice().getInstance().getProductName();

        if (productName.equals("cancro")) {
            return "com.uia.as2.devices.XiaoMiDevice";
        } else if (productName.equals("vbox86p")) {
            return "com.uia.as2.devices.Nexus5Device";
        }

        return "com.uia.as2.devices.Nexus5Device";
    }
}