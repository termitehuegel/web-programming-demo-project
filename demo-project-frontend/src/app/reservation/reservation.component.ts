import {Component} from '@angular/core';
import {FormsModule, NgForm} from "@angular/forms";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatDatepicker} from "@angular/material/datepicker";
import {HttpClient} from "@angular/common/http";
import {MatOption, MatSelect} from "@angular/material/select";
import {DatePipe, DecimalPipe, NgForOf, NgIf, Time} from "@angular/common";
import {MatButton} from "@angular/material/button";
import * as http from "http";

@Component({
    selector: 'app-reservation',
    standalone: true,
    imports: [
        FormsModule,
        MatFormField,
        MatInput,
        MatLabel,
        MatDatepicker,
        MatSelect,
        MatOption,
        DecimalPipe,
        MatButton,
        NgForOf,
        NgIf
    ],
    templateUrl: './reservation.component.html',
    styleUrl: './reservation.component.scss'
})
export class ReservationComponent {
    reservationPeriodStart: string = ""
    reservationPeriodEnd: string = ""
    times: Time[] = []
    success: boolean | null = null;

    constructor(private readonly http: HttpClient) {
        http.get<string[]>("http://localhost:8080/api/reservations/free").subscribe(dateStrings => {
            let dates: Date[] = dateStrings.map(string => new Date(string))
            let min: Date = dates[0]
            let max: Date = dates[0]
            dates.forEach(date => {
                if (date < min) {
                    min = date
                } else if (date > max) {
                    max = date
                }
            })
            let datePipe: DatePipe = new DatePipe('en-US')
            this.reservationPeriodStart = datePipe.transform(min, "YYYY-MM-dd") as string
            this.reservationPeriodEnd = datePipe.transform(max, "YYYY-MM-dd") as string
        })
    }

    updateTimes(form: NgForm) {
        let values: { name: string, amount: number | string, date: string, time: Time | string } = form.value as {
            name: string,
            amount: number | string,
            date: string,
            time: Time | string
        }
        if (!form.valid || values.amount == "" || values.amount == null || values.date == "") {
            this.times = []
            return
        }
        this.http.get<string[]>("http://localhost:8080/api/reservations/free/" + values.date + "/" + values.amount).subscribe(timeStrings => {
            let times: Time[] = timeStrings.map(string => {
                let segments: string[] = string.split(":")
                return {hours: parseInt(segments[0]), minutes: parseInt(segments[1])}
            })
            this.times = times
        })
    }

    onSubmit(form: NgForm) {
        let values: { name: string, amount: number | "" | null, date: string, time: Time | "" } = form.value as {
            name: string,
            amount: number | "" | null,
            date: string,
            time: Time | ""
        }
        if (!form.valid || values.name == "" || values.amount == "" || values.amount == null || values.date == "" || values.time == "") {
            return
        }
        this.http.put("http://localhost:8080/api/reservations", {
            name: values.name,
            amount: values.amount,
            date: values.date,
            time: (values.time.hours > 9 ? values.time.hours : "0" + values.time.hours) + ":" + (values.time.minutes > 9 ? values.time.minutes : "0" + values.time.minutes)
        }).subscribe(() => {
                form.resetForm()
                this.success = true
            }, e => {
                this.success = false
                form.resetForm()
            }
        )

    }
}
