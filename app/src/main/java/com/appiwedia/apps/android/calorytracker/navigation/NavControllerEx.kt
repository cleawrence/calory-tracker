package com.appiwedia.apps.android.calorytracker.navigation

import androidx.navigation.NavController
import com.appiwedia.apps.android.core.util.UiEvent


fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}