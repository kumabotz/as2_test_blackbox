package com.uia.as2.app;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

public class Option {
    private final UiObject mOptionUI;
    private final String mDefaultValue;

    public Option(List list, String value, String defaultValue) throws UiObjectNotFoundException {
        mOptionUI = list.getOption(value);
        mDefaultValue = defaultValue;
    }

    public void saveOption(String value) throws UiObjectNotFoundException {
        saveOption(value, false);
    }

    public void saveOption(String value, boolean manualSave) throws UiObjectNotFoundException {
        openDialog();
        selectOption(value);
        if (manualSave) {
            save();
        }
    }

    public void resetOption() throws UiObjectNotFoundException {
        saveOption(mDefaultValue);
    }

    public String description() throws UiObjectNotFoundException {
        return mOptionUI.getChild(new UiSelector().resourceId("android:id/summary")).getText();
    }

    public UiObject getUIObject() {
        return mOptionUI;
    }

    private void openDialog() throws UiObjectNotFoundException {
        mOptionUI.clickAndWaitForNewWindow();
    }

    private void selectOption(String value) throws UiObjectNotFoundException {
        UiScrollable listView = new UiScrollable(
                new UiSelector().resourceId("android:id/select_dialog_listview"));
        listView.getChildByText(
                new UiSelector().className(android.widget.CheckedTextView.class.getName()), value)
                .click();
    }

    private void save() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().text("Save")).clickAndWaitForNewWindow();
    }
}