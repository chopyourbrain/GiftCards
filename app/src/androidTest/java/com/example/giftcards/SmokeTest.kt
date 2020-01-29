package com.example.giftcards

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.agoda.kakao.screen.Screen
import com.example.core_utils.domain.model.CardDTO
import com.example.giftcards.presentation.activity.main.MainActivity
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SmokeTest :
    TestCase(Kaspresso.Builder.default().apply { flakySafetyParams.timeoutMs = 30000 }) {

    companion object {
        private const val NETWORK_ESTABLISHMENT_DELAY = 1_500L
    }

    private val list = listOf("Amazon.com", "iTunes", "Steam")

    private val firstItem = CardDTO()

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun smokeTest() = before {
        firstItem.apply {
            credits = 8500
            codesCount = 101
            description = "Buy everything from Amazon. It's great."
            redeemUrl = "http://www.amazon.com"
        }
        device.network.enable()
    }.after { device.network.enable() }.run {

        step("Check correct titles") {
            MainScreen {
                recycler {
                    isCompletelyDisplayed()
                    hasSize(list.size)
                    for (i in list.indices) {
                        childAt<Company>(i) {
                            title.hasText(list[i])
                            cardRecycler {
                                isDisplayed()
                            }
                        }
                    }
                }
            }
        }

        step("Check detail info") {
            MainScreen {
                recycler {
                    isCompletelyDisplayed()
                    hasSize(list.size)
                    firstChild<Company> {
                        cardRecycler {
                            firstChild<Card> {
                                click()
                            }
                        }
                    }
                }
            }
            DetailScreen {
                credits.hasText(firstItem.credits.toString())
                codesCount.hasText("${"$"}${firstItem.codesCount.toString()}.00")
                descriprion.hasText(firstItem.description ?: "")
                redeemUrl.hasText(firstItem.redeemUrl ?: "")
            }
        }

        step("Check cached info") {
            device.network.disable()
            Screen.idle(NETWORK_ESTABLISHMENT_DELAY)
            device.uiDevice.pressBack()
            MainScreen {
                swipeRefresh {
                    swipeDown()
                    isNotRefreshing()
                }
                recycler {
                    hasSize(list.size)
                }
            }
        }
    }

}