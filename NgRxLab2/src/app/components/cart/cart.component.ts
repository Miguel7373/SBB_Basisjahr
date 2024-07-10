import {Component, inject, OnInit} from '@angular/core';
import {MatButton, MatFabButton, MatIconButton} from "@angular/material/button";
import {RouterLink} from "@angular/router";
import {AsyncPipe, CurrencyPipe} from "@angular/common";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow, MatRowDef, MatTable, MatTableDataSource
} from "@angular/material/table";
import {MatIcon} from "@angular/material/icon";
import {ProductService} from "../../services/product.service";
import {map, Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {ProductModel} from "../../models/ProductModel";
import {removeProduct, clearCart} from "../../actions/cart.actions";

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [
    MatButton,
    RouterLink,
    CurrencyPipe,
    MatCell,
    MatCellDef,
    MatColumnDef,
    MatHeaderCell,
    MatHeaderRow,
    MatHeaderRowDef,
    MatIcon,
    MatIconButton,
    MatRow,
    MatRowDef,
    MatTable,
    MatHeaderCellDef,
    AsyncPipe,
    MatFabButton
  ],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.scss'
})
export class CartComponent{
  cart$: Observable<ProductModel[]>;
  total$: Observable<ProductModel[]>
  private store:Store<any> = inject(Store);
  displayedColumns: string[] = ['name', 'price', 'Actions'];



  constructor(protected productService:ProductService) {
    this.cart$ = this.store.select('count');
    this.total$ = this.store.select('count').pipe(map(products => products.reduce((total:number, product:ProductModel) => total + product.price, 0))
    );
  }
  removeFromCart(productId: number) {
    this.store.dispatch(removeProduct({ productId }));
  }

  clearCart() {
    this.store.dispatch(clearCart());
  }

  placeOrder() {
    this.clearCart();
    alert('Bestellung erfolgreich abgeschlossen!');
  }


}
