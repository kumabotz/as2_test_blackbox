package com.uia.as2.app;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uia.as2.tests.devices.Device;

public class App extends UiAutomatorTestCase {
    private final Device mDevice;
    private final String mAppName;

    public App(Device device, String appName) {
        mDevice = device;
        mAppName = appName;
    }

    public void launchApp() throws UiObjectNotFoundException {
        mDevice.launchApp(mAppName);
    }

    public void exitApp() throws RemoteException, UiObjectNotFoundException {
        mDevice.exitApp(mAppName);
    }

    public void launchSettings() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().description("More options")).clickAndWaitForNewWindow();
        new UiObject(new UiSelector().text("Settings")).clickAndWaitForNewWindow();
    }

    public void up() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().resourceId("android:id/up")).clickAndWaitForNewWindow();
    }

    public String actionBarTitle() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().resourceId("android:id/action_bar_title")).getText();
    }
}
