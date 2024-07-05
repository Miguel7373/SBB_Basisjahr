import {ApplicationConfig, isDevMode, provideZoneChangeDetection} from '@angular/core';
import {provideRouter} from '@angular/router';
import {provideStoreDevtools} from '@ngrx/store-devtools';

import {routes} from './app.routes';
import {provideStore} from "@ngrx/store";
import {counterReducer} from "./reducers/counter.reducer";
import {provideAnimations} from "@angular/platform-browser/animations";
import {provideAnimationsAsync} from "@angular/platform-browser/animations/async";
import {metaReducers, reducers} from "./reducers";

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({eventCoalescing: true}), provideRouter(routes),
    provideStore(reducers),
    provideStoreDevtools({maxAge: 25, logOnly: !isDevMode()}),
    provideAnimationsAsync(),
  ]
};
