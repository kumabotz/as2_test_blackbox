package com.uia.as2.app.settings;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class Settings {
    private final UiCollection mList;

    public Settings() {
        mList = new UiCollection(
                new UiSelector().className(android.widget.ListView.class.getName()));
    }

    public String listTitle() throws UiObjectNotFoundException {
        return mList.getChild(new UiSelector().resourceId("android:id/title")).getText();
    }

    public UiCollection getList() {
        return mList;
    }
}
