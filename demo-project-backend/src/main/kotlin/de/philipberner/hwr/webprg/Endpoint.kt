package de.philipberner.hwr.webprg

import org.apache.coyote.BadRequestException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpClientErrorException.BadRequest
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.HttpStatusCodeException
import java.net.HttpRetryException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@RestController
@RequestMapping("/api")
class Endpoint(
    private val db: DbMock
) {

    @CrossOrigin(originPatterns = ["*"])
    @GetMapping("/dishes")
    fun dishes(): List<Dish> {
        return db.dishes
    }

    @CrossOrigin(originPatterns = ["*"])
    @GetMapping("/dishes/{classification}")
    fun dishes(@PathVariable classification: DishClassification): List<Dish> {
        return db.dishes.filter { it.classification == classification }
    }

    @CrossOrigin(originPatterns = ["*"])
    @GetMapping("/dishes/{classification}/{name}")
    fun dishes(@PathVariable classification: DishClassification, @PathVariable name: String): Dish? {
        return db.dishes.find { it.classification == classification && it.name == name }
    }

    @CrossOrigin(originPatterns = ["*"])
    @GetMapping("reservations/free")
    fun reservations(): List<LocalDateTime> {
        val timeSlots: MutableList<LocalDateTime> = mutableListOf()

        for (day in 1..14) {
            val date: LocalDate = LocalDate.now().plusDays(day.toLong())
            timeSlots.addAll(reservations(date, 1).map { date.atTime(it) })
        }
        return timeSlots
    }

    @CrossOrigin(originPatterns = ["*"])
    @GetMapping("reservations/free/{date}/{amount}")
    fun reservations(@PathVariable date: LocalDate, @PathVariable amount: Int): List<LocalTime> {
        if (date !in LocalDate.now().plusDays(1)..LocalDate.now().plusDays(14)) {
            return emptyList()
        }

        val reservations: List<Reservation> = db.reservations.filter { it.date == date }
        return db.openingTime.find { it.day == date.dayOfWeek }!!.discretize()
            .filter { time ->
                reservations.filter { it.time <= time && it.time.plusHours(2).plusMinutes(30) > time }
                    .sumOf { it.amount } + amount <= db.capacity
            }
    }

    @CrossOrigin(originPatterns = ["*"])
    @PutMapping("reservations")
    fun reserve(@RequestBody reservation: Reservation) {
        if (reservation.name.isEmpty() ||
            reservation.amount !in 0..15 ||
            reservation.date !in LocalDate.now().plusDays(1)..LocalDate.now().plusDays(14) ||
            reservation.time !in (db.openingTime.find { it.day == reservation.date.dayOfWeek }?.discretize()?: throw BadRequestException()) ||
            !reservations(reservation.date, reservation.amount).contains(reservation.time)
            ) throw BadRequestException()

        db.reservations.add(reservation)
    }
}
