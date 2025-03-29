import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  constructor(private http: HttpClient) {}

  getServices(): Observable<any> {
    return this.http.get('http://localhost:4050/services');
  }

  getProjects(): Observable<any> {
    return this.http.get('http://localhost:4050/projects');
  }

  addEnquiry(data: any): Observable<any> {
    return this.http.post('http://localhost:4050/enquiries', data);
  }

  getEnquiries(): Observable<any> {
    return this.http.get('http://localhost:4050/enquiries');
  }

  getDetails(id: string): Observable<any> {
    return this.http.get(`http://localhost:4050/details?id=${id}`);
  }

  addEnquiryReply(data: any): Observable<any> {
    return this.http.post('http://localhost:4050/enquiryResponses', data);
  }
}
