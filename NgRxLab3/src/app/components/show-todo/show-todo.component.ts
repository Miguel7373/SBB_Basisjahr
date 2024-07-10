import { Component } from '@angular/core';
import {MatButton, MatMiniFabButton} from "@angular/material/button";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatIcon} from "@angular/material/icon";
import {RouterLink} from "@angular/router";
import {Observable} from "rxjs";
import {TodoModel} from "../../models/todoModel";
import {Store} from "@ngrx/store";
import {selectIncompleteTasks} from "../../selectors/todo.selector";
import {complete, removeTodo} from "../../actions/todo.actions";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-show-todo',
  standalone: true,
  imports: [
    MatButton,
    MatLabel,
    MatFormField,
    MatInput,
    MatIcon,
    MatMiniFabButton,
    RouterLink,
    AsyncPipe
  ],
  templateUrl: './show-todo.component.html',
  styleUrl: './show-todo.component.scss'
})
export class ShowTODOComponent {
  todos$: Observable<TodoModel[]>;

  constructor(private store: Store) {
    this.todos$ = this.store.select(selectIncompleteTasks);
  }

  onComplete(todoId: number) {
    this.store.dispatch(complete({ todoId }));
  }

  onRemove(todoId: number) {
    this.store.dispatch(removeTodo({ todoId }));
  }
}
