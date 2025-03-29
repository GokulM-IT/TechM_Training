import { Component } from '@angular/core';
import { service } from '../../model/service';
import { ApiService } from '../../services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  servicesList: service[] = [];

  constructor(private api: ApiService, private router: Router) {}

  onServiceClick(id: string) {
    const selectedService = this.servicesList.find(
      (service) => service.id === id
    );
    if (selectedService) {
      this.router.navigate(['/services', id], {
        state: { title: selectedService.title },
      });
    }
  }

  ngOnInit() {
    this.api.getServices().subscribe({
      next: (result: service[]) => (this.servicesList = result),
      error: (error) => console.log(error),
    });
  }
}
