import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'upperCaseWithCopyright',
  standalone: true
})
export class UpperCaseWithCopyrightPipe implements PipeTransform {

  transform(value: string): string {
    if (!value) return '';
    return value.toUpperCase()+ '©'
  }

}
