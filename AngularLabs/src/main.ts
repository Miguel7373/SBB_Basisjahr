import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import {BicycleComponent} from "./app/components/bicycle/bicycle.component";

bootstrapApplication(BicycleComponent, appConfig)
  .catch((err) => console.error(err));
