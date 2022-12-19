package com.appiwedia.apps.android.calorytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.appiwedia.apps.android.calorytracker.ui.theme.CaloryTrackerTheme
import com.appiwedia.apps.android.onboarding_presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
              WelcomeScreen()
            }
        }
    }
}