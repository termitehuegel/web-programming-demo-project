package de.philipberner.hwr.webprg

import org.springframework.stereotype.Component
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

@Component
class DbMock(
    val dishes: List<Dish> = listOf(
        Dish(DishClassification.APPETISER, "Pizza Pane", "Pizzabrot, frische Tomaten, Knoblauch, Rosmarin und Oliven Öl.", 300),
        Dish(DishClassification.APPETISER, "Carpaccio", "Ein Carpaccio vom Rind (roh), Rocula und Käse.", 200),
        Dish(DishClassification.APPETISER, "Bruschetta", "Tomaten, Knoblauch und Basilikum auf Brot.", 250),

        Dish(DishClassification.PIZZA, "Margherita", "Eine Pizza mit Tomatensauce, Mozzarella und Basilikum.", 700),
        Dish(DishClassification.PIZZA, "Funghi", "Eine Pizza mit Tomatensauce, Mozzarella, Basilikum und frischen Champignons.", 850),
        Dish(DishClassification.PIZZA, "Salami", "Eine Pizza mit Tomatensauce, Mozzarella, Basilikum und Salami.", 850),
        Dish(DishClassification.PIZZA, "Prosciutto Crudo", "Eine Pizza mit Tomatensauce, Mozzarella, Basilikum, Rucola und luftgetrocknetem Rohschinken.", 1000),
        Dish(DishClassification.PIZZA, "Tonno", "Eine Pizza mit Tomatensauce, Mozzarella, Basilikum, Zwiebeln und Tunfisch.", 1000),
        Dish(DishClassification.PIZZA, "Fritti di Mare", "Eine Pizza mit Tomatensauce, Mozzarella, Basilikum und Meeresfrüchten.", 1200),

        Dish(DishClassification.PASTA, "Spaghetti Bolognese", "Spaghetti mit einer Bolognesesauce.", 700),
        Dish(DishClassification.PASTA, "Spaghetti Marinara", "Spaghetti mit einer Marinara mit vielen Meeresfrüchten.", 1350),

        Dish(DishClassification.DESERT, "Panna Cotta", "Panna Cotta mit Erdbeersauce und Heidelbeeren.", 500),
        Dish(DishClassification.DESERT, "Tiramisù", "Tiramisu mit einem Espresso.", 500),
        Dish(DishClassification.DESERT, "Eis", "Eine Kugel Stracciatella und eine Kugel Latte Macchiato.", 650),
    ),
    val openingTime: List<OpeningTime> = listOf(
      OpeningTime(DayOfWeek.MONDAY, LocalTime.of(16, 0), LocalTime.of(20, 0)),
      OpeningTime(DayOfWeek.TUESDAY, LocalTime.of(16, 0), LocalTime.of(20, 0)),
      OpeningTime(DayOfWeek.WEDNESDAY, LocalTime.of(16, 0), LocalTime.of(20, 0)),
      OpeningTime(DayOfWeek.THURSDAY, LocalTime.of(16, 0), LocalTime.of(20, 0)),
      OpeningTime(DayOfWeek.FRIDAY, LocalTime.of(16, 0), LocalTime.of(22, 0)),
      OpeningTime(DayOfWeek.SATURDAY, LocalTime.of(15, 0), LocalTime.of(22, 0)),
      OpeningTime(DayOfWeek.SUNDAY, LocalTime.of(15, 0), LocalTime.of(22, 0)),
    ),
    val capacity: Int = 25,
    val reservations: MutableList<Reservation> = mutableListOf(
        Reservation("Max Muster", 2, LocalDate.now().plusDays(1), LocalTime.of(16, 0)),
        Reservation("Max Muster", 3, LocalDate.now().plusDays(1), LocalTime.of(16, 0)),
        Reservation("Max Muster", 5, LocalDate.now().plusDays(1), LocalTime.of(16, 0)),
        Reservation("Max Muster", 10, LocalDate.now().plusDays(1), LocalTime.of(16, 0)),
        Reservation("Max Muster", 3, LocalDate.now().plusDays(1), LocalTime.of(16, 0)),

        Reservation("Max Muster", 20, LocalDate.now().plusDays(2), LocalTime.of(16, 0)),
        Reservation("Max Muster", 5, LocalDate.now().plusDays(2), LocalTime.of(16, 30)),
        Reservation("Max Muster", 25, LocalDate.now().plusDays(2), LocalTime.of(19, 0)),

        Reservation("Max Muster", 10, LocalDate.now().plusDays(3), LocalTime.of(16, 0)),
        Reservation("Max Muster", 10, LocalDate.now().plusDays(3), LocalTime.of(16, 30)),
        Reservation("Max Muster", 5, LocalDate.now().plusDays(3), LocalTime.of(17, 0)),
        Reservation("Max Muster", 5, LocalDate.now().plusDays(3), LocalTime.of(18, 30)),

        Reservation("Max Muster", 10, LocalDate.now().plusDays(4), LocalTime.of(18, 0)),
        Reservation("Max Muster", 15, LocalDate.now().plusDays(4), LocalTime.of(19, 0)),

        Reservation("Max Muster", 10, LocalDate.now().plusDays(5), LocalTime.of(16, 0)),
        Reservation("Max Muster", 15, LocalDate.now().plusDays(5), LocalTime.of(18, 0)),

        Reservation("Max Muster", 10, LocalDate.now().plusDays(6), LocalTime.of(16, 0)),
        Reservation("Max Muster", 15, LocalDate.now().plusDays(6), LocalTime.of(18, 0)),

        Reservation("Max Muster", 7, LocalDate.now().plusDays(7), LocalTime.of(16, 0)),
        Reservation("Max Muster", 7, LocalDate.now().plusDays(7), LocalTime.of(17, 0)),
        Reservation("Max Muster", 7, LocalDate.now().plusDays(7), LocalTime.of(18, 0)),
        Reservation("Max Muster", 7, LocalDate.now().plusDays(7), LocalTime.of(19, 0))
    ),
    val orders: MutableList<Order> = mutableListOf()
)