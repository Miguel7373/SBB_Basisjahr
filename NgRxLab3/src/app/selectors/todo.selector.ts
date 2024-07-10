import { createSelector, createFeatureSelector } from '@ngrx/store';
import {TodoModel} from '../models/todoModel';

export const selectTasks = createFeatureSelector<TodoModel[]>('todos');

export const selectIncompleteTasks = createSelector(
  selectTasks,
  (todos: TodoModel[]) => todos
);
