import {ApplicationConfig, isDevMode, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {provideStore} from "@ngrx/store";
import {provideStoreDevtools} from '@ngrx/store-devtools';
import {reducers} from "./reducers";

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({eventCoalescing: true}), provideRouter(routes),
    provideStore(reducers),
    provideStoreDevtools({maxAge: 25, logOnly: !isDevMode()}),
    provideAnimationsAsync(),
  ]
};
