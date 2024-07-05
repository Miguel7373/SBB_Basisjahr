
import { isDevMode } from '@angular/core';
import {
  ActionReducerMap,
  MetaReducer
} from '@ngrx/store';
import {counterReducer} from "./counter.reducer";


export interface AppState {
}

export const reducers: ActionReducerMap<AppState> = {
  count: counterReducer,
};

export const metaReducers: MetaReducer<AppState>[] = isDevMode() ? [] : [];
