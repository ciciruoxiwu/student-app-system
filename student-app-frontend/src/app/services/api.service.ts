import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// -------------------- INTERFACES --------------------

export interface Application {
  id: number;
  companyName: string;
  studentId: number;
  applyDate: string;
  rejectDate: string;
  offerDate: string;
}

export interface Student {
  studentId: number;
  firstName: string;
  lastName: string;
  email: string;
}

// -------------------- SERVICE --------------------

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  // Get all applications
  getApplications(): Observable<Application[]> {
    return this.http.get<Application[]>(`${this.baseUrl}/applications`);
  }

  // Add new application (without id)
  addApplication(application: Omit<Application, 'id'>): Observable<Application> {
    return this.http.post<Application>(`${this.baseUrl}/applications`, application);
  }

  // Update application by ID
  updateApplication(id: number, application: Application): Observable<Application> {
    return this.http.put<Application>(`${this.baseUrl}/applications/${id}`, application);
  }

  // Delete application by ID
  deleteApplication(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/applications/${id}`);
  }

  // Get all students
  getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.baseUrl}/students`);
  }
}






