import {Component} from '@angular/core';
import {FormsModule, NgForm} from "@angular/forms";
import {MatCalendar, MatDatepicker} from "@angular/material/datepicker";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatIcon} from "@angular/material/icon";
import {MatInput} from "@angular/material/input";
import {MatButton, MatFabButton, MatIconButton, MatMiniFabButton} from "@angular/material/button";
import {DecimalPipe, NgForOf, NgIf} from "@angular/common";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {MatCard, MatCardContent, MatCardHeader} from "@angular/material/card";
import {
    MatCell,
    MatCellDef,
    MatColumnDef, MatFooterCell, MatFooterCellDef, MatFooterRow, MatFooterRowDef,
    MatHeaderCell,
    MatHeaderCellDef,
    MatHeaderRow, MatHeaderRowDef, MatRow, MatRowDef,
    MatTable
} from "@angular/material/table";
import {Dish} from "../menu/Dish";
import {OrderElement} from "./OrderElement";
import {OrderDataSource} from "./OrderDataSource";
import {MatDialog} from "@angular/material/dialog";
import {HttpClient} from "@angular/common/http";
import {AddDishDialogComponent} from "./add-dish-dialog/add-dish-dialog.component";

@Component({
    selector: 'app-delivery',
    standalone: true,
    imports: [
        FormsModule,
        MatDatepicker,
        MatCalendar,
        MatFormField,
        MatIcon,
        MatInput,
        MatLabel,
        MatIconButton,
        DecimalPipe,
        MatButton,
        MatOption,
        MatSelect,
        NgForOf,
        NgIf,
        MatCard,
        MatCardContent,
        MatCardHeader,
        MatTable,
        MatHeaderCell,
        MatCell,
        MatCellDef,
        MatHeaderCellDef,
        MatColumnDef,
        MatHeaderRow,
        MatRow,
        MatRowDef,
        MatHeaderRowDef,
        MatFooterCell,
        MatFooterCellDef,
        MatFooterRow,
        MatFooterRowDef,
        MatMiniFabButton,
        MatFabButton
    ],
    templateUrl: './delivery.component.html',
    styleUrl: './delivery.component.scss'
})
export class DeliveryComponent {

    success: boolean | null = null;
    order: OrderElement[] = []
    orderDisplayedColumns: string[] = ['dish', 'amount', 'price']
    orderDataSource: OrderDataSource = new OrderDataSource(this.order)

    constructor(private readonly dialog: MatDialog, private readonly http: HttpClient) {
    }

    totalCost(): number {
        return this.order.reduce((total, orderElement: {
            dish: Dish,
            amount: number
        }) => total + orderElement.amount * orderElement.dish.price, 0)
    }

    decreaseAmount(orderElement: OrderElement) {
        if (orderElement.amount > 1) {
            orderElement.amount--;
            return
        }

        let index = this.order.indexOf(orderElement)
        if (index > -1) {
            this.order.splice(index, 1)
            this.orderDataSource.setData(this.order)
        }
    }

    increaseAmount(orderElement: OrderElement) {
        orderElement.amount++;
    }

    openAddDishDialog() {
        const dialogRef = this.dialog.open(AddDishDialogComponent, {
            data: { selected: this.order }
        })
        dialogRef.afterClosed().subscribe(response => {
            if (response == undefined) return
            this.order.push( { dish: response, amount: 1 } )
            this.orderDataSource.setData(this.order)
        })
    }

    onSubmit(form: NgForm) {
        let values = form.value as {
            name: string,
            firstname: string,
            street: string,
            housenumber: string,
            postcode: string,
            note: string
        }
        if (!form.valid || this.order.length <= 0 || this.totalCost() <= 0 || values.name.length <= 0 || values.firstname.length <= 0 || values.street.length <= 0 || values.housenumber.length <= 0 || values.postcode.length != 5 ) {
            return
        }
        this.http.put("http://localhost:8080/api/orders", {
            deliveryInformation: {
                name: values.name,
                firstName: values.firstname,
                street: values.street,
                houseNumber: values.housenumber,
                postcode: values.postcode,
                note: values.note
            },
            items: this.order
        }).subscribe( {
                next: () => {
                    this.success = true
                    form.resetForm()
                    this.order = []
                    this.orderDataSource.setData(this.order)
                },
                error: () => {
                    this.success = false
                }
            }
        )
    }
}