package com.appiwedia.apps.android.tracker_data.mappers

import com.appiwedia.apps.android.tracker_data.local.entity.TrackedFoodEntity
import com.appiwedia.apps.android.tracker_domain.model.MealType
import com.appiwedia.apps.android.tracker_domain.model.TrackedFood
import java.time.LocalDate


fun TrackedFoodEntity.toTrackedFood(): TrackedFood {
    return TrackedFood(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        mealType = MealType.fromString(type),
        amount = amount,
        date = LocalDate.of(year, month, dayOfMonth),
        calories = calories,
        id = id
    )
}

fun TrackedFood.toTrackedFoodEntity(): TrackedFoodEntity {
    return  TrackedFoodEntity(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        calories = calories,
        id = id,
        year = date.year,
        month = date.monthValue,
        dayOfMonth = date.dayOfMonth,
        type = mealType.name,
        amount = amount
    )
}