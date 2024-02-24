import {Component, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Dish} from "./Dish";
import {NgForOf} from "@angular/common";
import {Menu} from "./Menu";

@Component({
    selector: 'app-menu',
    standalone: true,
    imports: [NgForOf],
    templateUrl: './menu.component.html',
    styleUrl: './menu.component.scss'
})
@Injectable()
export class MenuComponent {
    displayedColumns: string[] = ['name', 'description', 'price'];
    menu: Menu = {appetisers: [], main: {pizza: [], pasta: []}, dessert: []};

    constructor(private readonly http: HttpClient) {
        this.http = http
        this.loadMenu();
    }

    private loadMenu() {
        this.http.get<Dish[]>("http://localhost:8080/api/dishes/APPETISER").subscribe(dishes => this.menu.appetisers = dishes)
        this.http.get<Dish[]>("http://localhost:8080/api/dishes/DESERT").subscribe(dishes => this.menu.dessert = dishes)
        this.http.get<Dish[]>("http://localhost:8080/api/dishes/PIZZA").subscribe(dishes => this.menu.main.pizza = dishes)
        this.http.get<Dish[]>("http://localhost:8080/api/dishes/PASTA").subscribe(dishes => this.menu.main.pasta = dishes)
    }

    protected readonly Math = Math;
}
