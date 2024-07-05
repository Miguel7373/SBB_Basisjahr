import {createReducer, on} from "@ngrx/store";
import {decrement, increment, reset} from "../actions/counter.actions";

export const start:number = 0;

export const counterReducer = createReducer(
  start,
  on(increment, (state:number) => state + 1),
  on(decrement, (state:number) => state - 1),
  on(reset, state => 0)
);
