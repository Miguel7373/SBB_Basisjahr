import {createAction, props} from "@ngrx/store";
import {ProductModel} from "../models/ProductModel";
export enum ActionTypes {
  AddProduct = '[Cart] Add Product',
  RemoveProduct = '[Cart] Remove Product',
  ClearCart = '[Cart] Clear Cart'
}

export const addProduct = createAction(ActionTypes.AddProduct, props<{ product: ProductModel }>());
export const removeProduct = createAction(ActionTypes.RemoveProduct, props<{ productId: number }>());
export const clearCart = createAction(ActionTypes.ClearCart);
