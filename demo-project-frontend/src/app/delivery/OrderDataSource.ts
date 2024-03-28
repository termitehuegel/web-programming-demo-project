import {DataSource} from "@angular/cdk/collections";
import {OrderElement} from "./OrderElement";
import {Observable, ReplaySubject} from "rxjs";

export class OrderDataSource extends DataSource<OrderElement> {
    private _dataStream = new ReplaySubject<OrderElement[]>();

    constructor(initialData: OrderElement[]) {
        super();
        this.setData(initialData);
    }

    connect(): Observable<OrderElement[]> {
        return this._dataStream;
    }

    disconnect() {}

    setData(data: OrderElement[]) {
        this._dataStream.next(data);
    }
}