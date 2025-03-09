import { Pipe, PipeTransform } from '@angular/core';
import { enquiry } from '../model/enquiry';

@Pipe({
  name: 'filterService',
})
export class FilterServicePipe implements PipeTransform {
  transform(target: enquiry[], serviceType: string): enquiry[] {
    if (serviceType === 'All') return target;

    return target.filter((enquiry) => enquiry.serviceType === serviceType);
  }
}
