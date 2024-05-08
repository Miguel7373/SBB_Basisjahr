import { Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {HomeComponent} from "./components/home/home.component";
import {EditOrAddSubjectComponent} from "./components/edit-or-add-subject/edit-or-add-subject.component";
import {SpecificSubjectComponent} from "./components/specific-subject/specific-subject.component";
import {EditOrAddGradeComponent} from "./components/edit-or-add-grade/edit-or-add-grade.component";

export const routes: Routes = [
  {path: "", redirectTo: "login", pathMatch: "full"},
  {path: "login", component: LoginComponent},
  {path: "home", component: HomeComponent},
  {path: "subject/:usage", component: EditOrAddSubjectComponent},
  {path: "specific-Subject/:subject", component: SpecificSubjectComponent},
  {path: "grade/:usage", component: EditOrAddGradeComponent}
];
