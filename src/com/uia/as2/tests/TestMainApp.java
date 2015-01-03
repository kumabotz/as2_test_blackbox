package com.uia.as2.tests;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.uia.as2.app.main.IntervalSync;
import com.uia.as2.app.main.Main;
import com.uia.as2.app.main.ModeSync;
import com.uia.as2.app.main.SchedSync;

public class TestMainApp extends BaseTest {
    public void testSmoke() throws UiObjectNotFoundException {
        assertTrue("should launch app",
                new UiObject(new UiSelector().packageName("com.smallmachine.autosync2")).exists());
        assertTrue(
                "should have Sync Now",
                new UiObject(new UiSelector()
                        .resourceId("com.smallmachine.autosync2:id/action_sync_now")).exists());
        assertTrue("should have overflow menu",
                new UiObject(new UiSelector().description("More options")).exists());
        assertEquals(
                "should have default overview",
                "Select one or more options above to begin",
                new UiObject(new UiSelector()
                        .resourceId("com.smallmachine.autosync2:id/summaryView")).getText());
        assertEquals(
                "should have default status",
                "Sync is off",
                new UiObject(new UiSelector()
                        .resourceId("com.smallmachine.autosync2:id/statusView")).getText());
        assertTrue("should have ad",
                new UiObject(new UiSelector().resourceId("com.smallmachine.autosync2:id/adView"))
                        .exists());

        // sync options
        assertEquals("should have 3 sync options", new Main().getList().getChildCount(), 3);
        assertEquals("should have option description", "Touch to set a mode to turn on sync",
                new ModeSync().description());
        assertEquals("should have option description", "Touch to set how frequent to turn on sync",
                new IntervalSync().description());
        assertEquals("should have option description", "Touch to schedule a time to turn on sync",
                new SchedSync().description());
    }
}