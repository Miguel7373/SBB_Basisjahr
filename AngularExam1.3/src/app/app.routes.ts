import {Routes} from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {HomeComponent} from "./components/home/home.component";
import {AddMemberComponent} from "./components/add-member/add-member.component";
import {SettingsComponent} from "./components/settings/settings.component";
import {EditMemberComponent} from "./components/edit-member/edit-member.component";
import {AddEventComponent} from "./components/add-event/add-event.component";
import {loginGuard} from "./guards/login.guard";

export const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: "home", component: HomeComponent, canActivate: [loginGuard]},
  {path: "memberAdd/:text", component: AddMemberComponent, canActivate: [loginGuard]},
  {path: "settings", component: SettingsComponent, canActivate: [loginGuard]},
  {path: "edit/:user", component: EditMemberComponent, canActivate: [loginGuard]},
  {path: "event/:usage", component: AddEventComponent, canActivate: [loginGuard]}
// :time/:date/
];
