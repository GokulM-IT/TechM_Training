import { Pipe, PipeTransform } from '@angular/core';
import { CurrencyPipe } from '@angular/common';

@Pipe({
  name: 'customCurrency',
})
export class CustomCurrencyPipe implements PipeTransform {
  constructor(private currencyPipe: CurrencyPipe) {}

  transform(
    value: number | string,
    currencyCode: string = 'INR'
  ): string | null {
    return this.currencyPipe.transform(value, currencyCode, 'symbol', '1.0-0');
  }
}
