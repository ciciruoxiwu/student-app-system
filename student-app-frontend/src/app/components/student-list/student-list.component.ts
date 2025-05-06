import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; // ✅ 这行非常关键
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [CommonModule], // ✅ 确保这里包含 CommonModule
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: any[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.apiService.getStudents().subscribe((data) => {
      this.students = data;
    });
  }
}





