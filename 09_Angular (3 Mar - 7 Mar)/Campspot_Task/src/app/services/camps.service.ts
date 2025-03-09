import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Camp } from '../model/camp';

@Injectable({
  providedIn: 'root',
})
export class CampsService {
  constructor(private http: HttpClient) {}

  getCamps(): Observable<any> {
    return this.http.get('http://localhost:4050/details');
  }

  addCamp(camp: Camp): Observable<any> {
    return this.http.post('http://localhost:4050/details', camp);
  }
}
