import { Component, inject } from '@angular/core';
import { CampsService } from '../../services/camps.service';

@Component({
  selector: 'app-new-camp',
  standalone: false,
  templateUrl: './new-camp.component.html',
  styleUrls: ['./new-camp.component.css'],
})
export class NewCampComponent {
  isSubmitted = false;

  enteredName = '';
  enteredLocation = '';
  enteredPrice = '';
  enteredImageUrl = '';
  errors: string[] = [];

  private campsService = inject(CampsService);

  close() {
    this.isSubmitted = false;
  }

  validateForm() {
    this.errors = [];

    if (!this.enteredName || this.enteredName.length < 3) {
      this.errors.push('Name should be at least three characters long');
    }
    if (!this.enteredPrice || isNaN(Number(this.enteredPrice))) {
      this.errors.push('Price must be a valid number');
    }
    if (!this.enteredImageUrl || !this.enteredImageUrl.startsWith('http')) {
      this.errors.push('Please provide a valid URL for the image');
    }
    if (!this.enteredLocation || this.enteredLocation.length < 3) {
      this.errors.push('Location should be at least three characters long');
    }

    return this.errors.length === 0;
  }

  onSubmit() {
    if (this.validateForm()) {
      this.campsService
        .addCamp({
          location: this.enteredLocation,
          name: this.enteredName,
          price: this.enteredPrice,
          imageUrl: this.enteredImageUrl,
          stayDuration: 'night',
          rating: '0.0',
        })
        .subscribe({
          next: (response) => {
            this.isSubmitted = true;
            console.log('New camp:', response);
            this.enteredLocation = '';
            this.enteredName = '';
            this.enteredImageUrl = '';
            this.enteredPrice = '';
          },
          error: (error) => {
            alert('Something went wrong. Please try again');
          },
        });
    } else {
      console.log('Form validation failed', this.errors);
    }
  }
}
