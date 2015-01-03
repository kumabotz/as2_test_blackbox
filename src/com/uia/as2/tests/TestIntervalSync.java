package com.uia.as2.tests;

import android.os.RemoteException;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uia.as2.app.App;
import com.uia.as2.app.main.IntervalSync;

// TODO: should be able to update next interval time in airplane mode
// TODO: should update sub summary text when main summary text updated
// TODO: should disable sync interval when select none
public class TestIntervalSync extends Test {
    private App mApp;
    private IntervalSync mIntervalSync;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mApp = getApp();
        mIntervalSync = new IntervalSync();
    }

    @Override
    protected void tearDown() throws Exception {
        mIntervalSync.reset();
        super.tearDown();
    }

    public void xtestUpdateDescription() throws UiObjectNotFoundException {
        String value = "15 seconds";
        mIntervalSync.save(value);
        assertTrue(mIntervalSync.description().contains("every " + value + " (next "));
    }

    public void xtestUpdateDescriptionWhenRelaunch() throws UiObjectNotFoundException,
            RemoteException {
        String value = "5 minutes";
        mIntervalSync.save(value);
        mApp.relaunch();
        assertTrue(mIntervalSync.description().contains("every " + value + " (next "));
    }
}