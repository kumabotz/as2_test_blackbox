package com.uia.as2.devices;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

// genymotion nexus5
public class Base extends UiAutomatorTestCase implements Device {
    private final UiDevice mUiDevice;

    public Base() {
        mUiDevice = UiDevice.getInstance();
    }

    @Override
    public void launchApp(String appName) throws UiObjectNotFoundException {
        mUiDevice.pressHome();
        new UiObject(new UiSelector().text(appName)).clickAndWaitForNewWindow();
    }

    @Override
    public void exitApp(String appName) throws RemoteException, UiObjectNotFoundException {
        mUiDevice.pressRecentApps();
        new UiObject(new UiSelector().resourceId("com.android.systemui:id/app_thumbnail"))
                .swipeRight(5);
    }

    @Override
    public UiDevice getDevice() {
        return mUiDevice;
    }
}
