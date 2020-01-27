package com.example.giftcards

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.giftcards.presentation.activity.main.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SmokeTest : TestCase() {

    private val list = listOf("Amazon.com", "iTunes", "Steam")

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun checkCompanyTitles() = before {}.after {}.run {
        step("Correct titles") {
            MainScreen {
                recycler {
                    isCompletelyDisplayed()
                    hasSize(list.size)
                    for (i in list.indices) {
                        childAt<Company>(i) {
                            title.hasText(list[i])
                        }
                    }
                }
            }
        }
    }

}