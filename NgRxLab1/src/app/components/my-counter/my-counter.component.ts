import {Component, inject} from '@angular/core';
import {AsyncPipe} from "@angular/common";
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import { increment, decrement, reset } from '../../actions/counter.actions';


@Component({
  selector: 'app-my-counter',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  templateUrl: './my-counter.component.html',
  styleUrl: './my-counter.component.scss'
})
export class MyCounterComponent {
  count$: Observable<number>;
  private store:Store<any> = inject(Store);
  constructor() {
    this.count$ = this.store.select('count');
  }
  printCount(){
    this.count$.subscribe((res) => {
      console.log(res);
    })
  }

  increment() {
    this.store.dispatch(increment());
    this.printCount()
  }

  decrement() {
    this.store.dispatch(decrement());
    this.printCount()
  }

  reset() {
    this.store.dispatch(reset());
    this.printCount()
  }
}
