import {ApplicationConfig, ErrorHandler} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import {provideHttpClient, withFetch} from "@angular/common/http";
import {GlobalErrorHandler} from "./errors/global-error-handler.service";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes), provideClientHydration(), provideHttpClient(withFetch()),{provide: ErrorHandler, useClass: GlobalErrorHandler }, provideAnimationsAsync()]
};
