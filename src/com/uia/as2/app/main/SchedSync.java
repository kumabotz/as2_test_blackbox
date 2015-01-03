package com.uia.as2.app.main;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uia.as2.app.Option;

public class SchedSync extends Option {
    public SchedSync() throws UiObjectNotFoundException {
        super(new Main().getOption("Time"));
    }
}