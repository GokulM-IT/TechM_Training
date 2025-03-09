import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'highlight',
})
export class HighlightPipe implements PipeTransform {
  transform(target: string): string {
    let terms = [
      'campaign',
      'website',
      'project',
      'design',
      'hosting',
      'development',
      'marketing',
      'seo',
      'social',
      'media',
      'management',
      'content',
      'writing',
      'copywriting',
    ];

    terms.forEach((term) => {
      const regex = new RegExp(`\\b${term}\\b`, 'gi');
      target = target.replace(regex, (match) => `'${match.toUpperCase()}'`);
    });
    return target;
  }
}
