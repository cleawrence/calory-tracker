package com.appiwedia.apps.android.tracker_presentation.tracker_overview

import com.appiwedia.apps.android.tracker_domain.model.TrackedFood

sealed class TrackerOverViewEvent {
    object OnNextDayClick: TrackerOverViewEvent()
    object OnPreviousDayClick: TrackerOverViewEvent()
    data class OnToggleMealClick(val meal: Meal): TrackerOverViewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood): TrackerOverViewEvent()
}
