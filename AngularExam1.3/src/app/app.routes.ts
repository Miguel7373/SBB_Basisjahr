import {Routes} from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {HomeComponent} from "./components/home/home.component";
import {AddMemberComponent} from "./components/add-member/add-member.component";
import {SettingsComponent} from "./components/settings/settings.component";
import {EditMemberComponent} from "./components/edit-member/edit-member.component";
import {AddEventComponent} from "./components/add-event/add-event.component";

export const routes: Routes = [{path: "", component: LoginComponent}, {
  path: "home",
  component: HomeComponent
}, {path: "memberAdd/:text", component: AddMemberComponent}, {
  path: "settings",
  component: SettingsComponent
}, {path: "edit/:user", component: EditMemberComponent}, {path: "event/:usage", component: AddEventComponent}

// :time/:date/
];
