import { Routes } from '@angular/router';
import {ProductOverviewComponent} from "./components/product-overview/product-overview.component";
import {CartComponent} from "./components/cart/cart.component";

export const routes: Routes = [
  {path: "", component: ProductOverviewComponent},
  {path:"cart", component:CartComponent}
];
