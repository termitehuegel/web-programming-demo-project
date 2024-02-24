import { Routes } from '@angular/router';
import {MenuComponent} from "./menu/menu.component";
import {HomeComponent} from "./home/home.component";
import {ReservationComponent} from "./reservation/reservation.component";
import {DeliveryComponent} from "./delivery/delivery.component";
import {ImprintComponent} from "./imprint/imprint.component";
import {ContactComponent} from "./contact/contact.component";
import {DirectionComponent} from "./direction/direction.component";
import {PrivacyComponent} from "./privacy/privacy.component";

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'home', component: HomeComponent},
    {path: 'menu', component: MenuComponent},
    {path: 'menu', component: MenuComponent},
    {path: 'reservation', component: ReservationComponent},
    {path: 'delivery', component: DeliveryComponent},
    {path: 'direction', component: DirectionComponent},
    {path: 'contact', component: ContactComponent},
    {path: 'imprint', component: ImprintComponent},
    {path: 'privacy-policy', component: PrivacyComponent},
];
