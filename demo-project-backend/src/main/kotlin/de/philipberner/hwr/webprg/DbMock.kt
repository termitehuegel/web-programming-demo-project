package de.philipberner.hwr.webprg

import org.springframework.stereotype.Component

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
    )
) {

}