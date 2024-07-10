import {createAction} from "@ngrx/store";
import {ActionTypes} from "./enum";

export const increment = createAction(ActionTypes.INCREMENT);
export const decrement = createAction(ActionTypes.DECREMENT);
export const reset = createAction(ActionTypes.RESET);
