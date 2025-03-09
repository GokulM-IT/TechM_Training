import { Component, Input } from '@angular/core';
import { Camp } from '../../../model/camp';

@Component({
  selector: 'app-camps',
  standalone: false,
  templateUrl: './camps.component.html',
  styleUrl: './camps.component.css',
})
export class CampsComponent {
  @Input() camp!: Camp;
}
