import { Component } from '@angular/core';
import { Observable } from "rxjs";
import {CelciusToFahrenheitPipe} from "../../pipes/celcius-to-fahrenheit.pipe";

@Component({
  selector: 'app-celsius-to-fahreinheit',
  standalone: true,
  imports: [CelciusToFahrenheitPipe],
  providers:[CelciusToFahrenheitPipe] ,
  templateUrl: './celsius-to-fahreinheit.component.html',
  styleUrl: './celsius-to-fahreinheit.component.scss'
})
export class CelsiusToFahreinheitComponent {

  constructor(private celciusToFahrenheitPipe: CelciusToFahrenheitPipe) {
  }

  getRandomDegree(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  CelciusToFahreinhet() {
    const temperatureInC = new Observable<number>((subscriber) => {
      setInterval(() => {
        subscriber.next(this.getRandomDegree(0, 45));
      }, 2000);
    });

    temperatureInC.subscribe((celsius) => {
      const fahrenheit = this.celciusToFahrenheitPipe.transform(celsius)
      console.log(`Celsius: ${celsius}`, `Fahrenheit: ${fahrenheit}`);
    });
  }
}
