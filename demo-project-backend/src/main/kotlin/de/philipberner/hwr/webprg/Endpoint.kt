package de.philipberner.hwr.webprg

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
        return db.dishes.find { it.classification == classification &&  it.name == name }
    }
}