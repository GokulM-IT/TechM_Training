import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../../../services/api.service';

@Component({
  selector: 'app-enquiry-response',
  templateUrl: './enquiry-response.component.html',
  styleUrl: './enquiry-response.component.css',
})
export class EnquiryResponseComponent {
  constructor(private fb: FormBuilder, private api: ApiService) {}

  ids: string[] = [];
  emailState: boolean = true;
  email: string[] = [];
  enquiryForm: FormGroup = this.fb.group({
    subject: ['', Validators.required],
    message: ['', Validators.required],
    estimatedPrice: ['', Validators.required],
    duration: ['', Validators.required],
    email: [{ value: '', disabled: true }, Validators.required],
    messageId: ['', Validators.required],
  });

  ngOnInit() {
    this.api.getEnquiries().subscribe({
      next: (result: any) => {
        this.ids = result.map((enquiry: any) => enquiry.id);
        this.email = result.map((enquiry: any) => enquiry.email);
      },
      error: (error: any) => console.log(error),
    });
  }

  onIdChange(event: any) {
    const selectedId = event.target.value;
    alert(this.email[selectedId]);
    this.enquiryForm.patchValue({ email: this.email[selectedId] });
  }

  onSubmit() {
    if (this.enquiryForm.valid) {
      this.api.addEnquiryReply(this.enquiryForm.value).subscribe({
        next: (response: any) => {
          console.log('Enquiry response submitted successfully', response);
          alert('Enquiry response submitted successfully');
          this.enquiryForm.reset();
        },
        error: (error: any) => console.log(error),
      });
    }
  }
}
