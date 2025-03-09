import { Pipe, PipeTransform } from '@angular/core';
import { Project } from '../model/project';

@Pipe({
  name: 'statusFilter',
})
export class StatusFilterPipe implements PipeTransform {
  transform(projects: Project[], status: string): Project[] {
    if (!status) {
      return projects;
    }
    return projects.filter((project) => project.status === status);
  }
}
