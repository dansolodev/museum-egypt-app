package com.fs.museumegyptapp.model

import androidx.annotation.StringRes
import com.fs.museumegyptapp.R

data class EveryDayLifeSection(
    @StringRes val header: Int,
    val sections: List<Int>
)

val sectionsEveryDayLife = listOf(
    EveryDayLifeSection(
        header = R.string.section_work_economy,
        sections = listOf(
            R.string.work_agriculture,
            R.string.work_barter,
            R.string.work_hierarchy
        )
    ),
    EveryDayLifeSection(
        header = R.string.section_living_routine,
        sections = listOf(
            R.string.living_houses,
            R.string.living_food,
            R.string.living_hygiene
        )
    ),
    EveryDayLifeSection(
        header = R.string.section_culture_celebrations,
        sections = listOf(
            R.string.culture_festivities,
            R.string.living_food
        )
    ),
    EveryDayLifeSection(
        header = R.string.section_health_medicine,
        sections = listOf(
            R.string.health_holistic,
            R.string.health_herbs
        )
    )
)
