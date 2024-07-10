import {ApplicationConfig, isDevMode, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import {provideStore} from "@ngrx/store";
import {reducers} from "./reducers";
import {provideStoreDevtools} from '@ngrx/store-devtools';
import {provideAnimationsAsync} from "@angular/platform-browser/animations/async";


export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({eventCoalescing: true}), provideRouter(routes),
    provideStore(reducers),
    provideStoreDevtools({maxAge: 25, logOnly: !isDevMode()}),
    provideAnimationsAsync(),
  ]
};
