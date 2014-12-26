package com.uia.as2.tests.devices;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;

public interface Device {
    public void exitApp() throws RemoteException, UiObjectNotFoundException;
}