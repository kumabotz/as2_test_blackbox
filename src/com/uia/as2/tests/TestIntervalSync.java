package com.uia.as2.tests;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uia.as2.app.App;
import com.uia.as2.app.Main;
import com.uia.as2.app.Option;

// TODO: should be able to update next interval time in airplane mode
// TODO: should update sub summary text when main summary text updated
// TODO: should disable sync interval when select none
public class TestIntervalSync extends Test {
    private Option mIntervalSync;
    private App mApp;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mApp = getApp();
        mIntervalSync = new Option(new Main(), "Interval", "None");
    }

    @Override
    protected void tearDown() throws Exception {
        mIntervalSync.resetOption();
        super.tearDown();
    }

    public void testUpdateDescription() throws UiObjectNotFoundException {
        String value = "15 seconds";
        mIntervalSync.saveOption(value);
        assertTrue(mIntervalSync.description().contains("every " + value + " (next "));
    }

    public void testUpdateDescriptionWhenRelaunch() throws UiObjectNotFoundException, RemoteException {
        String value = "5 minutes";
        mIntervalSync.saveOption(value);
        mApp.relaunch();
        assertTrue(mIntervalSync.description().contains("every " + value + " (next "));
    }
}