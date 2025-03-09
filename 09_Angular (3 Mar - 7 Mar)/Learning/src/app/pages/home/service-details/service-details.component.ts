import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../../../services/api.service';

@Component({
  selector: 'app-service-details',
  templateUrl: './service-details.component.html',
  styleUrl: './service-details.component.css',
})
export class ServiceDetailsComponent {
  id: any = '';
  title: string = '';
  descTitle: string = '';
  description: string[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private api: ApiService
  ) {
    this.id = this.route.snapshot.paramMap.get('id');
    const navigation = this.router.getCurrentNavigation();
    console.log(navigation);

    if (navigation?.extras.state) {
      this.title = navigation.extras.state['title'];
      console.log('Title:', this.title);
    }
  }

  ngOnInit() {
    this.api.getDetails(this.id).subscribe({
      next: (result: any) => {
        console.log(result);
        this.descTitle = result[0].title;
        this.description = result[0].description;
      },
      error: (error: any) => console.log(error),
    });
  }
}
