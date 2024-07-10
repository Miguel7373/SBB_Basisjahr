import {Component, inject} from '@angular/core';
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatButton, MatFabButton, MatMiniFabButton} from "@angular/material/button";
import {Router, RouterLink} from "@angular/router";
import {MatIcon} from "@angular/material/icon";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {Store} from "@ngrx/store";
import {addTodo} from "../../actions/todo.actions";
import {routes} from "../../app.routes";

@Component({
  selector: 'app-create-todo',
  standalone: true,
  imports: [
    MatFormField,
    MatInput,
    MatLabel,
    MatButton,
    RouterLink,
    MatIcon,
    MatMiniFabButton,
    MatFabButton,
    ReactiveFormsModule
  ],
  templateUrl: './create-todo.component.html',
  styleUrl: './create-todo.component.scss'
})
export class CreateTODOComponent {
  todoName: FormControl = new FormControl('');
  private store:Store<any> = inject(Store);

  constructor(private router:Router) {
  }

  protected submit(){
    if (this.todoName){
      const  newTodo = {
        id: new Date().getTime(),
        name: this.todoName.value,
        completed: false
      }
      this.store.dispatch(addTodo({ todo: newTodo }));
      this.todoName.reset();
      this.router.navigate(['/'])
    }
  }
}
