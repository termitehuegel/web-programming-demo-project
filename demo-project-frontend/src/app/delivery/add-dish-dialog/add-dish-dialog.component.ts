import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogModule, MatDialogRef} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";
import {HttpClient} from "@angular/common/http";
import {OrderElement} from "../OrderElement";
import {Dish} from "../../menu/Dish";
import {NgForOf, NgIf} from "@angular/common";
import {MatDivider} from "@angular/material/divider";

@Component({
    selector: 'app-add-dish-dialog',
    standalone: true,
    imports: [MatDialogModule, MatButtonModule, NgForOf, MatDivider, NgIf],
    templateUrl: './add-dish-dialog.component.html',
    styleUrl: './add-dish-dialog.component.scss'
})
export class AddDishDialogComponent {

    dishes: Dish[] = []

    constructor(private dialogRef: MatDialogRef<AddDishDialogComponent>, private readonly http: HttpClient, @Inject(MAT_DIALOG_DATA) data: { selected: OrderElement[] }) {
        this.http.get<Dish[]>("http://localhost:8080/api/dishes").subscribe(dishes =>
            this.dishes = dishes
                .filter(dish => data.selected
                    .find(order => order.dish.name == dish.name) == undefined)
                    .sort((a, b) => a.price - b.price))
    }

    selectDish(dish: Dish) {
        this.dialogRef.close(dish)
    }
}