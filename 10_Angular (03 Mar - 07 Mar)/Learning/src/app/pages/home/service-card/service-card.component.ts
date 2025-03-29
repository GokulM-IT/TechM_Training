import { Component, Input } from '@angular/core';
import { service } from '../../../model/service';

@Component({
  selector: 'app-service-card',
  templateUrl: './service-card.component.html',
  styleUrl: './service-card.component.css',
})
export class ServiceCardComponent {
  @Input() service: service = { id: '', title: '', description: '', image: '' };

  get imagePath() {
    return 'http://localhost:8090/' + this.service.image;
  }
}
