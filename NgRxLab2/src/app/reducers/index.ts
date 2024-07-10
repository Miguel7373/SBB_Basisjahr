import {ActionReducerMap, MetaReducer} from "@ngrx/store";
import {isDevMode} from "@angular/core";
import {_cartReducer} from "./cart.reducer";


export interface AppState {
}

export const reducers: ActionReducerMap<AppState> = {
  count: _cartReducer,
};



export const metaReducers: MetaReducer<AppState>[] = isDevMode() ? [] : [];
