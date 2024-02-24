import {DishClassification} from "./DishClassification";

export type Dish = {
    readonly classification: DishClassification,
    readonly name: string,
    readonly description: string,
    readonly price: number //euro cent

}