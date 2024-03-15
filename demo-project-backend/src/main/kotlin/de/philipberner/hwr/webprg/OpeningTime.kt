package de.philipberner.hwr.webprg

import java.time.DayOfWeek
import java.time.LocalTime

data class OpeningTime(
    val day: DayOfWeek,
    val opening: LocalTime,
    val closing: LocalTime,
) {
    fun discretize(): List<LocalTime> {
        if (opening.isAfter(closing)) return emptyList()
        val discreteTimes: MutableList<LocalTime> = mutableListOf()
        var time: LocalTime = LocalTime.of(opening.hour, if (opening.minute >= 30) 30 else 0)
        while (time <= closing.minusHours(1)) {
            discreteTimes.add(time)
            time = time.plusMinutes(30)
        }
        return discreteTimes
    }
}
