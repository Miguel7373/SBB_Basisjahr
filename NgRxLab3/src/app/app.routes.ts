import { Routes } from '@angular/router';
import {ShowTODOComponent} from "./components/show-todo/show-todo.component";
import {createComponent} from "@angular/core";
import {CreateTODOComponent} from "./components/create-todo/create-todo.component";

export const routes: Routes = [
  {path: "", component: ShowTODOComponent},
  {path: "add", component: CreateTODOComponent}
];
