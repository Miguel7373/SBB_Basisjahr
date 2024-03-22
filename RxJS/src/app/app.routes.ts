import { Routes } from '@angular/router';
import {IntervalComponent} from "./components/interval/interval.component";
import {CelsiusToFahreinheitComponent} from "./components/celsius-to-fahreinheit/celsius-to-fahreinheit.component";
import {SubjectsComponent} from "./components/subjects/subjects.component";

export const routes: Routes = [
  {
    path: '', component: SubjectsComponent
  }
];
