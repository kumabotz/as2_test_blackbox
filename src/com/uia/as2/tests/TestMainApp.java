package com.uia.as2.tests;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

public class TestMainApp extends Test {
    public void testSmoke() throws UiObjectNotFoundException {
        // app
        assertTrue("should launch app",
                new UiObject(new UiSelector().packageName("com.smallmachine.autosync2")).exists());

        // sync now
        assertTrue(
                "should have Sync Now",
                new UiObject(new UiSelector()
                        .resourceId("com.smallmachine.autosync2:id/action_sync_now")).exists());

        // overflow menu
        assertTrue("should have overflow menu",
                new UiObject(new UiSelector().description("More options")).exists());

        // overview
        assertEquals(
                "should have default overview",
                "Select one or more options above to begin",
                new UiObject(new UiSelector()
                        .resourceId("com.smallmachine.autosync2:id/summaryView")).getText());

        // status
        assertEquals(
                "should have default status",
                "Sync is off",
                new UiObject(new UiSelector()
                        .resourceId("com.smallmachine.autosync2:id/statusView")).getText());

        // ad
        assertTrue("should have ad",
                new UiObject(new UiSelector().resourceId("com.smallmachine.autosync2:id/adView"))
                        .exists());
    }

    public void testOptions() throws UiObjectNotFoundException {
        UiScrollable options = new UiScrollable(
                new UiSelector().className("android.widget.ListView"));
        assertEquals("should have 3 sync options", options.getChildCount(), 3);

        compareOption(
                options.getChildByInstance(
                        new UiSelector().className("android.widget.LinearLayout"), 0), "Mode",
                "Touch to set a mode to turn on sync");
        compareOption(
                options.getChildByInstance(
                        new UiSelector().className("android.widget.LinearLayout"), 1), "Interval",
                "Touch to set how frequent to turn on sync");
        compareOption(
                options.getChildByInstance(
                        new UiSelector().className("android.widget.LinearLayout"), 2), "Time",
                "Touch to schedule a time to turn on sync");
    }

    void compareOption(UiObject option, String optionTitle, String optionValue)
            throws UiObjectNotFoundException {
        assertTrue("should have option title", option.getChild(new UiSelector().text(optionTitle))
                .exists());
        assertTrue("should have option value", option.getChild(new UiSelector().text(optionValue))
                .exists());
    }
}