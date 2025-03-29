import { Pipe, PipeTransform } from '@angular/core';
import { Project } from '../model/project';

@Pipe({
  name: 'teamSizeFilter',
})
export class TeamSizeFilterPipe implements PipeTransform {
  transform(projects: Project[], min: number, max: number): Project[] {
    if (!projects) return [];
    return projects.filter(
      (project) => project.teamSize >= min && project.teamSize <= max
    );
  }
}
