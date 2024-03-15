import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'currency',
  standalone: true
})
export class CurrencyPipe implements PipeTransform {

  transform(value: number, currency: string = 'CHF'): string {
    let roundedValue = Math.round(value).toString()
    for (let i = roundedValue.length -3; i > 0 ; i-=3) {
      roundedValue = roundedValue.slice(0,i) + "'" + roundedValue.slice(i);
    }
    return roundedValue + '.00 ' + currency;
  }

}
