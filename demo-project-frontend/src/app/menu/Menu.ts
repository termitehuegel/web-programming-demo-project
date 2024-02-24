import {Dish} from "./Dish";

export type Menu = {
    appetisers: Dish[],
    main: {
        pizza: Dish[],
        pasta: Dish[]
    },
    dessert: Dish[]

}