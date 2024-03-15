package de.philipberner.hwr.webprg

import java.time.LocalDate
import java.time.LocalTime

data class Reservation(
    val name: String,
    val amount: Int,
    val date: LocalDate,
    val time: LocalTime
)
