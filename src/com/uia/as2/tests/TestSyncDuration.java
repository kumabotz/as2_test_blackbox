package com.uia.as2.tests;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uia.as2.app.App;
import com.uia.as2.app.Option;
import com.uia.as2.app.Settings;

public class TestSyncDuration extends Test {
    private App mApp;
    private Option mSyncDuration;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mApp = getApp();
        mApp.launchSettings();
        mSyncDuration = new Option(new Settings(), "Sync Duration", "1 minute");
    }

    @Override
    protected void tearDown() throws Exception {
        mSyncDuration.resetOption();
        super.tearDown();
    }

    public void testSaveSyncDuration() throws UiObjectNotFoundException, RemoteException {
        String value = "5 seconds";
        mSyncDuration.saveOption(value, true);
        relaunchSettings();
        assertEquals("should saved sync duration value", value, mSyncDuration.description());
    }

    private void relaunchSettings() throws UiObjectNotFoundException, RemoteException {
        mApp.relaunch();
        mApp.launchSettings();
    }
}