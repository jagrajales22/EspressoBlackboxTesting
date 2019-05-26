package com.example.espresso_blackbox_testing.pageobject

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.ViewMatchers.withResourceName
import com.azimolabs.conditionwatcher.ConditionWatcher.waitForCondition
import com.example.espresso_blackbox_testing.instruction.LoadingElementInstruction
import org.hamcrest.Matcher

class LoginPageObject {

    private val usernameTextField: Matcher<View> = withResourceName("edt_username")
    private val passwordTextField: Matcher<View> = withResourceName("edt_password")
    private val loginButton: Matcher<View> = withResourceName("btn_login")

    fun doLogin(username: String, password: String) {
        waitForCondition(LoadingElementInstruction(usernameTextField))
        onView(usernameTextField).perform(replaceText(username))
        onView(passwordTextField).perform(replaceText(password))
        onView(loginButton).perform(click())
    }
}