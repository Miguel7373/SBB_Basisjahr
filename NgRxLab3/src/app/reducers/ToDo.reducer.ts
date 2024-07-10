import {createReducer, on} from "@ngrx/store";
import {addTodo, removeTodo, complete} from "../actions/todo.actions";

export const initialState:any[] = [];

export const _todoReducer = createReducer(
  initialState,
  on(addTodo, (state, { todo }) => [...state, todo]),
  on(removeTodo, (state, { todoId }) => state.filter(task => task.id !== todoId)),
  on(complete, (state, { todoId }) => state.map(task =>
    task.id === todoId ? { ...task, completed: true } : task))
);

export function todoReducer(state: any, action: any) {
  return _todoReducer(state, action);
}
