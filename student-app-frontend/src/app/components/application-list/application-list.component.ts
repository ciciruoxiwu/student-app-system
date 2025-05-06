import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService, Application } from '../../services/api.service';

@Component({
  selector: 'app-application-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './application-list.component.html'
})
export class ApplicationListComponent implements OnInit {
  applications: Application[] = [];

  newApplication: Omit<Application, 'id'> = {
    companyName: '',
    studentId: 0,
    applyDate: '',
    rejectDate: '',
    offerDate: ''
  };

  editingApplication: Application | null = null;

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.fetchApplications();
  }

  fetchApplications(): void {
    this.apiService.getApplications().subscribe((data: Application[]) => {
      this.applications = data;
    });
  }

  addApplication(): void {
    this.apiService.addApplication(this.newApplication).subscribe(() => {
      this.fetchApplications();
      this.newApplication = {
        companyName: '',
        studentId: 0,
        applyDate: '',
        rejectDate: '',
        offerDate: ''
      };
    });
  }

  editApplication(application: Application): void {
    this.editingApplication = { ...application };
  }

  updateApplication(): void {
    if (this.editingApplication) {
      this.apiService.updateApplication(this.editingApplication.id, this.editingApplication).subscribe(() => {
        this.fetchApplications();
        this.editingApplication = null;
      });
    }
  }

  cancelEdit(): void {
    this.editingApplication = null;
  }

  deleteApplication(id: number): void {
    this.apiService.deleteApplication(id).subscribe(() => {
      this.fetchApplications();
    });
  }
}
















