package com.uia.as2.devices;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Nexus5Device extends UiAutomatorTestCase implements Device {
    private final UiDevice mUiDevice;

    public Nexus5Device() {
        mUiDevice = UiDevice.getInstance();
    }

    @Override
    public void exitApp() throws RemoteException, UiObjectNotFoundException {
        mUiDevice.pressRecentApps();
        new UiObject(new UiSelector().resourceId("com.android.systemui:id/app_thumbnail"))
                .swipeRight(5);
    }
}
