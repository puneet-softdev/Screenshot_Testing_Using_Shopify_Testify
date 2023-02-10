package com.codingwithpuneet.screenshottestingandroid

import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.shopify.testify.ScreenshotRule
import com.shopify.testify.annotation.ScreenshotInstrumentation
import com.shopify.testify.annotation.TestifyLayout
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    //@get:Rule
    //var rule = ScreenshotRule(MainActivity::class.java)

    @get:Rule var rule = ScreenshotRule(
        activityClass = MainActivity::class.java,
        launchActivity = false,
        rootViewId = R.id.clMain
    )

    @ScreenshotInstrumentation
    @Test
    fun default() {
        rule.assertSame()
    }

    @ScreenshotInstrumentation
    @TestifyLayout(R.layout.activity_main)
    @Test
    fun testHugeFontScale() {
        rule
            .setFontScale(2.0f)
            .assertSame()
    }

    @TestifyLayout(R.layout.activity_main)
    @ScreenshotInstrumentation
    @Test
    fun setEspressoActions() {
        rule
            .setEspressoActions {
                onView(withId(com.codingwithpuneet.screenshottestingandroid.R.id.etTType)).perform(typeText("Puneet"))
            }
            .assertSame()
    }

    @TestifyLayout(R.layout.activity_main)
    @ScreenshotInstrumentation
    @Test
    fun setOrientation() {
        rule
            .setOrientation(requestedOrientation = SCREEN_ORIENTATION_LANDSCAPE)
            .assertSame()
    }
}