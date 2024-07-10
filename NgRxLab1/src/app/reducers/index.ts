import {ActionReducerMap, MetaReducer} from "@ngrx/store";
import {counterReducer} from "./counter.reducer";
import {isDevMode} from "@angular/core";

export interface AppState {
}

export const reducers: ActionReducerMap<AppState> = {
  count: counterReducer,
};

export const metaReducers: MetaReducer<AppState>[] = isDevMode() ? [] : [];
