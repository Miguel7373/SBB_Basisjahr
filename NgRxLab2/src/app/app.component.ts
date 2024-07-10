import {Component, inject} from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {MatIcon} from "@angular/material/icon";
import {MatIconButton} from "@angular/material/button";
import {MatBadge} from "@angular/material/badge";
import {map, Observable} from "rxjs";
import {ProductModel} from "./models/ProductModel";
import {Store} from "@ngrx/store";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatIcon, MatIconButton, MatBadge, RouterLink, AsyncPipe],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'NgRxLab2';
  cartCount$: Observable<ProductModel[]>;
  private store:Store<any> = inject(Store);

  constructor() {
    this.cartCount$ = this.store.select('count').pipe(map(products => products.reduce((total:number, product:ProductModel) => total + 1, 0)));
  }

}
