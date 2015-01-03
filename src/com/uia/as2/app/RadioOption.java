package com.uia.as2.app;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

public class RadioOption extends Option {
    private final String mDefaultValue;

    public RadioOption(UiObject uiObject, String defaultValue) throws UiObjectNotFoundException {
        super(uiObject);
        mDefaultValue = defaultValue;
    }

    public void save(String value) throws UiObjectNotFoundException {
        openDialog();
        selectOption(value);
    }

    public void reset() throws UiObjectNotFoundException {
        save(mDefaultValue);
    }

    private void selectOption(String value) throws UiObjectNotFoundException {
        UiScrollable listView = new UiScrollable(
                new UiSelector().resourceId("android:id/select_dialog_listview"));
        listView.getChildByText(
                new UiSelector().className(android.widget.CheckedTextView.class.getName()), value)
                .click();
    }
}