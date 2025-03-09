import { Component, Input } from '@angular/core';
import { contact } from '../../../model/contact';

@Component({
  selector: 'app-contact-item',
  templateUrl: './contact-item.component.html',
  styleUrl: './contact-item.component.css',
})
export class ContactItemComponent {
  @Input() contact: contact = {
    name: '',
    city: '',
    state: '',
    address: '',
    phone: '',
    image: '',
  };

  get imagePath() {
    return 'http://localhost:8090/' + this.contact.image;
  }
}
