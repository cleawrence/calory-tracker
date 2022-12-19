package com.appiwedia.apps.android.core.util

sealed class UiEvent {
    data class Navigate(val route: String): UiEvent()
    object NavigateUp: UiEvent()
}
