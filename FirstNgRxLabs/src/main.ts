import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import {provideStore} from "@ngrx/store";
import {counterReducer} from "./app/reducers/counter.reducer";

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));


// bootstrapApplication(AppComponent, {
//   providers: [
//     provideStore({ count: counterReducer })
//   ],
// });
//
