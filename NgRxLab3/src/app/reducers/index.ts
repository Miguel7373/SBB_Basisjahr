import {ActionReducerMap, MetaReducer} from "@ngrx/store";
import {isDevMode} from "@angular/core";
import {_todoReducer} from "./ToDo.reducer";


export interface AppState {
}

export const reducers: ActionReducerMap<AppState> = {
  todos: _todoReducer,
};



export const metaReducers: MetaReducer<AppState>[] = isDevMode() ? [] : [];
