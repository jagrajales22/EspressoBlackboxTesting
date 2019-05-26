@file:Suppress("DEPRECATION")

package com.example.espresso_blackbox_testing


import android.content.Intent
import androidx.test.InstrumentationRegistry
import com.example.espresso_blackbox_testing.pageobject.ContactPageObject
import com.example.espresso_blackbox_testing.pageobject.LoginPageObject
import com.example.espresso_blackbox_testing.pageobject.SearchContactPageObject
import org.junit.After
import org.junit.Before
import org.junit.Test


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ContactCallTest {

    private val activityToBeTested = "com.mytaxi.android_demo.activities.MainActivity"
    private val username = "crazydog335"
    private val password = "venture"
    private val searchText = "sa"
    private val contactName = "Sarah Scott"

    private val loginPageObject = LoginPageObject()
    private val searchContactPageObject = SearchContactPageObject()
    private val contactPageObject = ContactPageObject()

    @Before
    fun setup() {
        val activityClass: Class<*>?
        try {
            activityClass = Class.forName(activityToBeTested)
        } catch (e: Exception) {
            e.printStackTrace()
            return
        }

        val instrumentation = InstrumentationRegistry.getInstrumentation()
        instrumentation.setInTouchMode(true)

        val targetPackage = instrumentation.targetContext.packageName
        val startIntent = Intent(Intent.ACTION_MAIN)
        startIntent.setClassName(targetPackage, activityClass!!.name)
        startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        instrumentation.startActivitySync(startIntent)
        instrumentation.waitForIdleSync()
    }


    @Test
    fun successfullyCallContact() {
        // Context of the app under test.
        loginPageObject.doLogin(username, password)

        searchContactPageObject.searchContact(searchText, contactName)

        contactPageObject.callContact()
    }

    @After
    fun quit() {

    }

}
