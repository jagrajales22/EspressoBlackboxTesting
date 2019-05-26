package com.example.espresso_blackbox_testing.pageobject

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withResourceName
import com.azimolabs.conditionwatcher.ConditionWatcher.waitForCondition
import com.example.espresso_blackbox_testing.instruction.LoadingElementInstruction
import org.hamcrest.Matcher

class ContactPageObject {

    private val callContactButton: Matcher<View> = withResourceName("fab")

    fun callContact() {
        waitForCondition(LoadingElementInstruction(callContactButton))
        onView(callContactButton).perform(click())
    }
}