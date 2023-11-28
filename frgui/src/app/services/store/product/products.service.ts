import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  getProducts(): Observable<any> {
    return this.http.get<any>(`${this.apiServerUrl}/product/getAll`);
  }

  findByCategory(): Observable<any> {
    return this.http.get<any>(`${this.apiServerUrl}/product/findByCategory`);
  }

  getCategories(): Observable<any> {
    return this.http.get<any>(`${this.apiServerUrl}/product/getCategories`);
  }
}
