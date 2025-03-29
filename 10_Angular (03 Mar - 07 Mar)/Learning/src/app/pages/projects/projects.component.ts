import { Component } from '@angular/core';
import { Project } from '../../model/project';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css'],
})
export class ProjectsComponent {
  projectsList: Project[] = [];
  selectedStatus: string = '';
  teamSizeMin: number = 0;
  teamSizeMax: number = 20;

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getProjects().subscribe({
      next: (result: Project[]) => (this.projectsList = result),
      error: (error: any) => console.log(error),
    });
  }
}
