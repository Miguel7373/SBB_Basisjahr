import {Component} from '@angular/core';
import {Observable} from "rxjs";

@Component({
  selector: 'app-interval',
  standalone: true,
  imports: [],
  templateUrl: './interval.component.html',
  styleUrl: './interval.component.scss'
})
export class IntervalComponent {


  getRandomInterval(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  interval() {

    const intervalObservable: Observable<number> = new Observable<number>(subscriber => {
      const interval: number = this.getRandomInterval(1000, 5000);
      const intervalId = setInterval(() => {
        subscriber.next(interval);
      }, interval)
      return () => {
        clearInterval(intervalId);
      };
    });

    intervalObservable.subscribe((interval) => {
      console.log(`Interval: ${interval}ms`);
    });
  }
}
