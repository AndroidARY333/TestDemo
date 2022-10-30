package com.app.demo.ui.main.list

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.app.demo.R
import com.app.demo.ui.main.ParentActivity
import com.app.demo.ui.main.adapter.PeopleViewHolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class PeopleListFragmentTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(ParentActivity::class.java)

    private val LIST_ITEM_IN_TEST = 3

    // Verify PeopleList Recycle View displaying
    @Test
    fun test_isListFragmentVisible_onAppLaunch() {
        onView(withId(R.id.characters_rv)).check(matches(isDisplayed()))

    }

    @Test
    fun test_selectListItem_isDetailFragmentVisible() {
        // Click list item #LIST_ITEM_IN_TEST

        /**
         *
         * Way -1 to Testing Recycle view
         * */
        onView(withId(R.id.characters_rv))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<PeopleViewHolder>(
                    LIST_ITEM_IN_TEST,
                    ViewActions.click()
                )
            )

        /**
         *
         * Way -2 to Testing Recycle view
         * */
       /* Espresso.onView(ViewMatchers.withId(R.id.characters_rv)).perform(RecyclerViewActions.actionOnItemAtPosition<PeopleViewHolder>(5,click()))
        val itemName:String ="Turner"
        Espresso.onView(withText(itemName)).check(matches(isDisplayed()))*/


        // Confirm nav to DetailFragment and display title
          //  onView(withId(R.id.people_title)).check(matches(withText(LIST_IN_TEST.title)))

        // VERIFY

        onView(withId(R.id.people_details_fragment))
            .check(matches(isDisplayed()))


        Espresso.pressBack()


        // VERIFY
        // NAV PeopleList Fragment
        onView(withId(R.id.people_list_fragment))
            .check(matches(isDisplayed()))

    }





}