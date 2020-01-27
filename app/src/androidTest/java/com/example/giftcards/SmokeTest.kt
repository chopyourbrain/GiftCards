package com.example.giftcards

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.giftcards.presentation.activity.main.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class SmokeTest : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun checkCompanyTitles() = before { }.after { }.run {
        step("Step 1. Screen") {
            MainScreen {
                recycler {
                    isCompletelyDisplayed()
                    for (i in 0..2) {
                        childAt<Company>(i) {
                            when (i) {
                                0 -> title.hasText("Amazon.com")
                                1 -> title.hasText("iTunes")
                                2 -> title.hasText("Steam")
                            }
                        }
                    }

                }
            }
        }
    }
}