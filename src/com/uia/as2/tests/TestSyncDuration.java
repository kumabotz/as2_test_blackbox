package com.uia.as2.tests;

import android.os.RemoteException;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class TestSyncDuration extends Test {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        launchSettings();
    }

    public void testSaveSyncDuration() throws UiObjectNotFoundException, RemoteException {
        String syncDuration = "5 seconds";
        saveSyncDuration(syncDuration);
        relaunchSettings();
        assertEquals("should have saved sync duration", syncDuration, syncDurationLayout()
                .getChild(new UiSelector().resourceId("android:id/summary")).getText());
        resetSyncDuration();
    }

    private void saveSyncDuration(String syncDuration) throws UiObjectNotFoundException {
        syncDurationLayout().clickAndWaitForNewWindow();
        UiCollection listView = new UiCollection(
                new UiSelector().resourceId("android:id/select_dialog_listview"));
        UiObject syncDurationOption = listView.getChildByText(
                new UiSelector().className(android.widget.CheckedTextView.class.getName()),
                syncDuration);
        syncDurationOption.click();
        new UiObject(new UiSelector().text("Save")).clickAndWaitForNewWindow();
    }

    private void resetSyncDuration() throws UiObjectNotFoundException {
        saveSyncDuration("1 minute");
    }

    private void launchSettings() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().description("More options")).clickAndWaitForNewWindow();
        new UiObject(new UiSelector().text("Settings")).clickAndWaitForNewWindow();
    }

    private void relaunchSettings() throws UiObjectNotFoundException, RemoteException {
        super.exitApp();
        super.launchApp();
        launchSettings();
    }

    private UiObject syncDurationLayout() throws UiObjectNotFoundException {
        UiCollection listView = new UiCollection(
                new UiSelector().className(android.widget.ListView.class.getName()));
        return listView.getChildByText(
                new UiSelector().className(android.widget.RelativeLayout.class.getName()),
                "Sync Duration");
    }
}