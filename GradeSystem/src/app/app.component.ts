import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MatIcon} from "@angular/material/icon";
import {MatIconButton, MatMiniFabButton} from "@angular/material/button";
import {TranslateLoader, TranslateModule, TranslateService, TranslateStore} from '@ngx-translate/core';
import {Environment} from "./environment/Environment";
import {MatSelect} from "@angular/material/select";
import {MatMenu, MatMenuItem, MatMenuTrigger} from "@angular/material/menu";
import {HttpClient} from "@angular/common/http";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";

function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http)
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatIcon, MatMiniFabButton, MatIconButton, MatSelect, MatMenuTrigger, MatMenu, MatMenuItem, TranslateModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title:string = 'GradeSystem';

  constructor(private translateService: TranslateService) {}

  ngOnInit():void {
    this.translateService.addLangs(Environment.languages);
    this.changeLanguage('de')
  }

  changeLanguage(lang: string):void {
    this.translateService.use(lang);
  }


  protected readonly Environment = Environment;
}
