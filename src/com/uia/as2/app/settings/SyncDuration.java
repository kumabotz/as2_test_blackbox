package com.uia.as2.app.settings;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.uia.as2.app.RadioOption;

public class SyncDuration extends RadioOption {
    public SyncDuration() throws UiObjectNotFoundException {
        super(new Settings().getOption("Sync Duration"), "1 minute");
    }

    @Override
    public void save(String value) throws UiObjectNotFoundException {
        super.save(value);
        new UiObject(new UiSelector().text("Save")).clickAndWaitForNewWindow();
    }
}
