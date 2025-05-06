import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-offer-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './offer-list.component.html',
  styleUrls: ['./offer-list.component.css']
})
export class OfferListComponent implements OnInit {
  offers: any[] = [];
  filteredOffers: any[] = [];
  selectedCompany: string = '';
  selectedStudent: string = '';
  companies: string[] = [];
  studentIds: string[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:8080/api/offers')
      .subscribe(data => {
        this.offers = data;
        this.filteredOffers = data;
        this.companies = [...new Set(data.map(o => o.companyName))];
        this.studentIds = [...new Set(data.map(o => o.studentId))];
      });
  }

  filterOffers() {
    this.filteredOffers = this.offers.filter(o =>
      (!this.selectedCompany || o.companyName === this.selectedCompany) &&
      (!this.selectedStudent || o.studentId == this.selectedStudent)
    );
  }

  getAverageSalary(): number {
    if (this.filteredOffers.length === 0) return 0;
    const total = this.filteredOffers.reduce((sum, offer) => sum + (offer.salary || 0), 0);
    return +(total / this.filteredOffers.length).toFixed(2);
  }

  getMaxSalary(): number {
    if (this.filteredOffers.length === 0) return 0;
    return Math.max(...this.filteredOffers.map(o => o.salary || 0));
  }

  getMinSalary(): number {
    if (this.filteredOffers.length === 0) return 0;
    return Math.min(...this.filteredOffers.map(o => o.salary || 0));
  }

  updateOfferField(offer: any, field: string, value: any) {
    offer[field] = value;
    this.http.put(`http://localhost:8080/api/offers/${offer.id}`, offer).subscribe();
  }
}



