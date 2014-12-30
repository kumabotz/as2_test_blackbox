package com.uia.as2.app.settings;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class SyncDuration extends SettingsOption {
    public SyncDuration() throws UiObjectNotFoundException {
        super("Sync Duration");
    }

    public void saveSyncDuration(String value) throws UiObjectNotFoundException {
        openOptionDialog();
        selectOption(value);
        save();
    }

    private void openOptionDialog() throws UiObjectNotFoundException {
        super.getOptionUI().clickAndWaitForNewWindow();
    }

    private void selectOption(String value) throws UiObjectNotFoundException {
        UiCollection listView = new UiCollection(
                new UiSelector().resourceId("android:id/select_dialog_listview"));
        listView.getChildByText(
                new UiSelector().className(android.widget.CheckedTextView.class.getName()), value)
                .click();
    }

    private void save() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().text("Save")).clickAndWaitForNewWindow();
    }

    public void resetSyncDuration() throws UiObjectNotFoundException {
        saveSyncDuration("1 minute");
    }
}
