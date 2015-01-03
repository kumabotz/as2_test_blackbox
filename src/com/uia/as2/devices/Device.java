package com.uia.as2.devices;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;

public interface Device {
    public void exitApp(String appName) throws RemoteException, UiObjectNotFoundException;

    public void launchApp(String appName) throws UiObjectNotFoundException;

    public UiDevice getDevice();
}