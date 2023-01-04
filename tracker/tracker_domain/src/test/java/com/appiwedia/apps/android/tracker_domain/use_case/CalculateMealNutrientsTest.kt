package com.appiwedia.apps.android.tracker_domain.use_case

import com.appiwedia.apps.android.core.domain.models.ActivityLevel
import com.appiwedia.apps.android.core.domain.models.Gender
import com.appiwedia.apps.android.core.domain.models.GoalType
import com.appiwedia.apps.android.core.domain.models.UserInfo
import com.appiwedia.apps.android.core.domain.preferences.Preferences
import com.appiwedia.apps.android.tracker_domain.model.MealType
import com.appiwedia.apps.android.tracker_domain.model.TrackedFood
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import kotlin.random.Random


class CalculateMealNutrientsTest {

    private lateinit var calculateMealNutrients: CalculateMealNutrients

    @Before
    fun setUp() {
        val preferences = mockk<Preferences>(relaxed = true)
        every { preferences.loadUserInfo() } returns UserInfo(
            gender = Gender.Male,
            age = 25,
            height = 185,
            weight = 85f,
            activityLevel = ActivityLevel.Medium,
            goalType = GoalType.KeepWeight,
            carbRatio = 0.4f,
            proteinRatio = 0.3f,
            fatRatio = 0.3f
        )
        calculateMealNutrients = CalculateMealNutrients(preferences)
    }

    @Test
    fun `Calories for breakfast properly calculate`() {
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                mealType = MealType.fromString(
                    listOf("breakfast", "lunch", "dinner", "snack").random()
                ),
                imageUrl = null,
                amount = 90,
                date = LocalDate.now(),
                calories = Random.nextInt(1000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val breakFastCalories = result.mealNutrients.values
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.calories }
        val expectedCalories = trackedFoods
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.calories }

        assertThat(breakFastCalories).isEqualTo(expectedCalories)
    }

    @Test
    fun `Carbs for dinner properly calculate`() {
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                mealType = MealType.fromString(
                    listOf("breakfast", "lunch", "dinner", "snack").random()
                ),
                imageUrl = null,
                amount = 90,
                date = LocalDate.now(),
                calories = Random.nextInt(1000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val dinnerCarbs = result.mealNutrients.values
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.carbs }
        val expectedCarbs = trackedFoods
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.carbs }

        assertThat(dinnerCarbs).isEqualTo(expectedCarbs)
    }

    @Test
    fun `Fat for lunch properly calculate`() {
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                mealType = MealType.fromString(
                    listOf("breakfast", "lunch", "dinner", "snack").random()
                ),
                imageUrl = null,
                amount = 90,
                date = LocalDate.now(),
                calories = Random.nextInt(1000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val fatLunch = result.mealNutrients.values
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.fat }
        val expectedFat = trackedFoods
            .filter { it.mealType is MealType.Lunch }
            .sumOf { it.fat }

        assertThat(fatLunch).isEqualTo(expectedFat)
    }

    @Test
    fun `Proteins for snack properly calculate`() {
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                mealType = MealType.fromString(
                    listOf("breakfast", "lunch", "dinner", "snack").random()
                ),
                imageUrl = null,
                amount = 90,
                date = LocalDate.now(),
                calories = Random.nextInt(1000)
            )
        }
        val result = calculateMealNutrients(trackedFoods)

        val lunchProtein = result.mealNutrients.values
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.protein }
        val expectedProteins = trackedFoods
            .filter { it.mealType is MealType.Snack }
            .sumOf { it.protein }

        assertThat(lunchProtein).isEqualTo(expectedProteins)
    }
}