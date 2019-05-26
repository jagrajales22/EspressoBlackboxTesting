package com.example.espresso_blackbox_testing.pageobject

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.RootMatchers.isPlatformPopup
import androidx.test.espresso.matcher.ViewMatchers.withResourceName
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.azimolabs.conditionwatcher.ConditionWatcher.waitForCondition
import com.example.espresso_blackbox_testing.instruction.LoadingElementInstruction
import org.hamcrest.Matcher
import org.hamcrest.Matchers.containsString

class SearchContactPageObject {

    private val searchTextField: Matcher<View> = withResourceName("textSearch")

    fun searchContact(searchText: String, contactName: String) {

        waitForCondition(LoadingElementInstruction(searchTextField))

        onView(searchTextField)
            .perform(click(), replaceText(searchText))

        onView(withText(containsString(contactName)))
            .inRoot(isPlatformPopup())
            .perform(click())
    }
}