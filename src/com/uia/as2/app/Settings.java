package com.uia.as2.app;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class Settings extends List {
    public Settings() {
        super(android.widget.RelativeLayout.class.getName());
    }

    public String listTitle() throws UiObjectNotFoundException {
        return getList().getChild(new UiSelector().resourceId("android:id/title")).getText();
    }
}