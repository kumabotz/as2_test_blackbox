package com.uia.as2.tests.devices;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class XiaoMi extends Base implements Device {
    private final UiDevice mUiDevice;

    public XiaoMi() {
        mUiDevice = getDevice();
    }

    @Override
    public void exitApp(String appName) throws RemoteException, UiObjectNotFoundException {
        mUiDevice.pressHome();
        mUiDevice.pressRecentApps();
        sleep(500);
        new UiObject(new UiSelector().text(appName)).swipeUp(40);
    }
}