import { Component, Input } from '@angular/core';
import { Project } from '../../../model/project';

@Component({
  selector: 'app-project-card',
  templateUrl: './project-card.component.html',
  styleUrl: './project-card.component.css',
})
export class ProjectCardComponent {
  @Input() project: Project = {
    id: '',
    name: '',
    description: '',
    status: '',
    startDate: '',
    endDate: '',
    teamSize: 0,
    image: '',
  };

  get imagePath() {
    return 'http://localhost:8090/' + this.project.image;
  }
}
