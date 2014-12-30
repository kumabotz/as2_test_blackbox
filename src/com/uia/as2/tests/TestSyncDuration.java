package com.uia.as2.tests;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uia.as2.app.App;
import com.uia.as2.app.settings.SyncDuration;

public class TestSyncDuration extends Test {
    private App mApp;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mApp = super.getApp();
        mApp.launchSettings();
    }

    public void testSaveSyncDuration() throws UiObjectNotFoundException, RemoteException {
        String value = "5 seconds";
        SyncDuration syncDuration = new SyncDuration();
        syncDuration.saveSyncDuration(value);
        relaunchSettings();
        assertEquals("should saved sync duration value", value, syncDuration.description());
        syncDuration.resetSyncDuration();
    }

    private void relaunchSettings() throws UiObjectNotFoundException, RemoteException {
        mApp.exitApp();
        mApp.launchApp();
        mApp.launchSettings();
    }
}