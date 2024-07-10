import {Component, inject} from '@angular/core';
import {ProductService} from "../../services/product.service";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef, MatHeaderRow, MatHeaderRowDef, MatRow,
  MatRowDef,
  MatTable
} from "@angular/material/table";
import {MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {CurrencyPipe} from "@angular/common";
import {RouterLink} from "@angular/router";
import {Store} from "@ngrx/store";
import {addProduct} from "../../actions/cart.actions";
import {ProductModel} from "../../models/ProductModel";

@Component({
  selector: 'app-product-overview',
  standalone: true,
  imports: [
    MatCell,
    MatHeaderCell,
    MatColumnDef,
    MatTable,
    MatCellDef,
    MatHeaderCellDef,
    MatRowDef,
    MatHeaderRowDef,
    MatHeaderRow,
    MatRow,
    MatIconButton,
    MatIcon,
    CurrencyPipe,
    RouterLink
  ],
  templateUrl: './product-overview.component.html',
  styleUrl: './product-overview.component.scss'
})
export class ProductOverviewComponent {
  displayedColumns: string[] = ['name', 'price', 'Actions'];
  private store:Store<any> = inject(Store);

  constructor(protected productService:ProductService) {
  }
  addToCart(product: ProductModel) {
    const id:number = new Date().getTime();
    const newProduct = {...product, id:id}
    this.store.dispatch(addProduct({ product:newProduct }));
  }
}
