import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'celciusToFahrenheit',
  standalone: true
})
export class CelciusToFahrenheitPipe implements PipeTransform {
  transform(celsius: number): number {
    return (celsius * 9 / 5) + 32;
  }
}
