package com.example.espresso_blackbox_testing.instruction

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.azimolabs.conditionwatcher.Instruction
import org.hamcrest.Matcher


class LoadingElementInstruction(private val loadingElement: Matcher<View>) : Instruction() {

    override fun getDescription(): String {
        return "Search bar should be displayed"
    }

    override fun checkCondition(): Boolean {
        val element = onView(loadingElement)
        try {
            element.check(matches(isDisplayed()))
            return true
        } catch (e: NoMatchingViewException) {
            return false
        }
    }
}

