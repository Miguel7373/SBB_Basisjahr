import { Routes } from '@angular/router';
import {BicycleInfoComponent} from "./components/bicycle-info/bicycle-info.component";
import {BicycleSearchComponent} from "./components/bicycle-search/bicycle-search.component";
import {bicycleGuard} from "./guards/bicycle.guard";
import {BrandComponent} from "./components/brand/brand.component";


export const routes: Routes = [
  {
    path: '', component: BicycleInfoComponent
  },
  {
    path: `searchComponent`, component: BicycleSearchComponent, canActivate: [bicycleGuard]
  },
  {
    path: 'brand/:id', component: BrandComponent
  }
];
