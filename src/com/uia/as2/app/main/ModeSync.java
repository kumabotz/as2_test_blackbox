package com.uia.as2.app.main;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.uia.as2.app.RadioOption;

public class ModeSync extends RadioOption {
    public ModeSync() throws UiObjectNotFoundException {
        super(new Main().getOption("Mode"), "None");
    }
}