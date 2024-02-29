package com.example.pppmax

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pppmax.presentation.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testMainActivity() {
        // Simular a interação do usuário (por exemplo, inserir texto em um EditText)
        onView(withId(R.id.edit_id))
            .perform(typeText("id"))

        // Simular um clique em um botão
        onView(withId(R.id.button_pesquisar))
            .perform(click())
    }
}