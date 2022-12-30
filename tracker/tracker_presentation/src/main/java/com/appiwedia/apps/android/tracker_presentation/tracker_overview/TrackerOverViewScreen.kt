package com.appiwedia.apps.android.tracker_presentation.tracker_overview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.appiwedia.apps.android.core.util.UiEvent
import com.appiwedia.apps.android.core_ui.LocalSpacing
import com.appiwedia.apps.android.tracker_presentation.tracker_overview.components.DaySelector
import com.appiwedia.apps.android.tracker_presentation.tracker_overview.components.ExpandableMeal
import com.appiwedia.apps.android.tracker_presentation.tracker_overview.components.NutrientsHeader

@Composable
fun TrackerOverviewScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: TrackerOverviewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spacing.spaceMedium)
    ) {
        item {
            NutrientsHeader(state = state)
            DaySelector(
                date = state.date,
                onPreviousDayClick = { viewModel.onEvent(TrackerOverViewEvent.OnPreviousDayClick) },
                onNextDayClick = { viewModel.onEvent(TrackerOverViewEvent.OnNextDayClick) },
                modifier = Modifier.padding(horizontal = spacing.spaceMedium)
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
        }
        items(state.meals) { meal ->
            ExpandableMeal(
                meal = meal,
                onToggleClick = { viewModel.onEvent(TrackerOverViewEvent.OnToggleMealClick(meal)) },
                content = {

                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}