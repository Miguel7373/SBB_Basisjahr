import {createAction, props} from "@ngrx/store";
import {TodoModel} from "../models/todoModel";
export enum ActionTypes {
  AddTodo= '[Todo] Add Todo',
  RemoveTodo = '[Todo] Remove Todo',
  Complete = '[Todo] Complete Todo'
}

export const addTodo = createAction(ActionTypes.AddTodo, props<{ todo: TodoModel }>());
export const removeTodo = createAction(ActionTypes.RemoveTodo, props<{ todoId: number }>());
export const complete = createAction(ActionTypes.Complete, props<{ todoId: number }>());
