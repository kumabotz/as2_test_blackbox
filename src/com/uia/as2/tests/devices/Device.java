package com.uia.as2.tests.devices;

import com.android.uiautomator.core.UiObjectNotFoundException;

import android.os.RemoteException;

public interface Device {
    public void exitApp() throws RemoteException, UiObjectNotFoundException;
}