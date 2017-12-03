package com.androidessence.cashcaretaker.transaction

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.androidessence.cashcaretaker.R
import com.androidessence.cashcaretaker.RecyclerViewItemCountAssertion
import com.androidessence.cashcaretaker.TestUtils.Companion.setChecked

/**
 * Robot for interacting with the Transaction view.
 */
class TransactionRobot {
    fun clickNew(): TransactionRobot {
        onView(ADD_BUTTON_MATCHER).perform(ViewActions.click())
        return this
    }

    fun submit(): TransactionRobot {
        onView(SUBMIT_BUTTON_MATCHER).perform(ViewActions.click())
        return this
    }

    fun assertListCount(expectedCount: Int): TransactionRobot {
        onView(RECYCLER_VIEW_MATCHER).check(RecyclerViewItemCountAssertion.withItemCount(expectedCount))
        return this
    }

    fun setWithdrawalSwitch(checked: Boolean): TransactionRobot {
        onView(WITHDRAWAL_SWITCH_MATCHER).perform(setChecked(checked))
        return this
    }

    fun assertWithdrawalSwitchState(checked: Boolean): TransactionRobot {
        val checkedMatcher = if (checked) isChecked() else isNotChecked()
        onView(WITHDRAWAL_SWITCH_MATCHER).check(matches(checkedMatcher))
        return this
    }

    fun transactionDescription(description: String): TransactionRobot {
        onView(TRANSACTION_DESCRIPTION_MATCHER).perform(clearText(), typeText(description), closeSoftKeyboard())
        return this
    }

    fun transactionAmount(amount: String): TransactionRobot {
        onView(TRANSACTION_AMOUNT_MATCHER).perform(clearText(), typeText(amount), closeSoftKeyboard())
        return this
    }

    companion object {
        private val RECYCLER_VIEW_ID = R.id.transactions
        private val WITHDRAWAL_SWITCH_ID = R.id.withdrawalSwitch
        private val TRANSACTION_DESCRIPTION_ID = R.id.transactionDescription
        private val TRANSACTION_AMOUNT_ID = R.id.transactionAmount

        private val ADD_BUTTON_MATCHER = withId(R.id.add_transaction)
        private val RECYCLER_VIEW_MATCHER = withId(RECYCLER_VIEW_ID)
        private val WITHDRAWAL_SWITCH_MATCHER = withId(WITHDRAWAL_SWITCH_ID)
        private val TRANSACTION_DESCRIPTION_MATCHER = withId(TRANSACTION_DESCRIPTION_ID)
        private val TRANSACTION_AMOUNT_MATCHER = withId(TRANSACTION_AMOUNT_ID)
        private val SUBMIT_BUTTON_MATCHER = withId(R.id.submitButton)
    }
}