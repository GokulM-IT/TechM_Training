import { Component } from '@angular/core';
import { CampsService } from '../../services/camps.service';
import { Camp } from '../../model/camp';

@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  camps!: Camp[];

  constructor(private campsService: CampsService) {}

  ngOnInit() {
    this.campsService.getCamps().subscribe({
      next: (result: Camp[]) => {
        this.camps = result;
      },
      error: (error: any) => console.log(error),
    });
  }
}
