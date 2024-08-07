import { Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {HomeComponent} from "./components/home/home.component";
import {EditOrAddSubjectComponent} from "./components/edit-or-add-subject/edit-or-add-subject.component";
import {SpecificSubjectComponent} from "./components/specific-subject/specific-subject.component";
import {EditOrAddGradeComponent} from "./components/edit-or-add-grade/edit-or-add-grade.component";
import {loginGuard} from "./guards/login.guard";

export const routes: Routes = [
  {path: "", redirectTo: "login", pathMatch: "full"},
  {path: "login", component: LoginComponent},
  {path: "home", component: HomeComponent, canActivate: [loginGuard]},
  {path: "subject/:usage", component: EditOrAddSubjectComponent, canActivate: [loginGuard]},
  {path: "specific-Subject/:subject", component: SpecificSubjectComponent, canActivate: [loginGuard]},
  {path: "grade/:subject/:usage", component: EditOrAddGradeComponent, canActivate: [loginGuard]}
];
