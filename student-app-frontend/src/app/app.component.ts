import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ApplicationListComponent } from './components/application-list/application-list.component';
import { StudentListComponent } from './components/student-list/student-list.component';
import { OfferListComponent } from './components/offer-list/offer-list.component';
import { CompanyListComponent } from './components/company-list/company-list.component'; // ✅ 添加这行

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    ApplicationListComponent,
    StudentListComponent,
    OfferListComponent,
    CompanyListComponent 
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'] 
})
export class AppComponent {
  title = 'student-app-frontend';
}




