import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import {provideClientHydration} from "@angular/platform-browser";
import {HttpClient, provideHttpClient, withFetch, withInterceptors} from "@angular/common/http";
import {provideAnimationsAsync} from "@angular/platform-browser/animations/async";
import { MAT_DATE_LOCALE} from "@angular/material/core";
import {TranslateLoader, TranslateModule, TranslateService, TranslateStore} from "@ngx-translate/core";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
// import {AuthInterceptor} from "./interceptors/interceptor";
function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http)
}

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes), provideClientHydration(), provideHttpClient(withFetch()), provideAnimationsAsync(), provideAnimationsAsync(), provideAnimationsAsync(),{provide: MAT_DATE_LOCALE, useValue: 'en-GB'}, TranslateService,TranslateStore,TranslateModule.forRoot({loader: {
      provide: TranslateLoader,
      useFactory: HttpLoaderFactory,
      deps: [HttpClient]
    }}).providers!]
};
// ,(withInterceptors([AuthInterceptor]))
