package com.uia.as2.app;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class Option {
    private final UiObject mUiObject;

    public Option(UiObject uiObject) {
        mUiObject = uiObject;
    }

    public String description() throws UiObjectNotFoundException {
        return mUiObject.getChild(new UiSelector().resourceId("android:id/summary")).getText();
    }

    public void openDialog() throws UiObjectNotFoundException {
        mUiObject.clickAndWaitForNewWindow();
    }
}
