package com.uia.as2.app.main;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uia.as2.app.RadioOption;

public class IntervalSync extends RadioOption {
    public IntervalSync() throws UiObjectNotFoundException {
        super(new Main().getOption("Interval"), "None");
    }
}
