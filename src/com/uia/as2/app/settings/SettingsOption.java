package com.uia.as2.app.settings;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class SettingsOption {
    private final UiObject mOptionUI;

    public SettingsOption(String value) throws UiObjectNotFoundException {
        mOptionUI = new Settings().getList().getChildByText(
                new UiSelector().className(android.widget.RelativeLayout.class.getName()), value);
    }

    public String description() throws UiObjectNotFoundException {
        return mOptionUI.getChild(new UiSelector().resourceId("android:id/summary")).getText();
    }

    public UiObject getOptionUI() {
        return mOptionUI;
    }
}
