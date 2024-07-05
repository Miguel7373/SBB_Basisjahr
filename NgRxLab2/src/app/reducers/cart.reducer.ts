import { createReducer, on } from '@ngrx/store';
import { addProduct, removeProduct, clearCart } from './cart.actions';

export const initialState:any[] = [];


const _cartReducer = createReducer(
  initialState,
  on(addProduct, (state, { product }) => [...state, product]),
  on(removeProduct, (state, { productId }) => state.filter(product => product.id !== productId)),
  on(clearCart, () => initialState)
);

export function cartReducer(state: any, action: any) {
  return _cartReducer(state, action);
}
