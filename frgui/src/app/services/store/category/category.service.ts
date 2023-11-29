import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  // we are going to provide a current value (selected by user) based off of the sidebar categories
  // then we are going to pass it to the products component in the store component
  private selectedCategorySubject: BehaviorSubject<string> = new BehaviorSubject<string>('');
  selectedCategory$: Observable<string> = this.selectedCategorySubject.asObservable();

  constructor() { }

  setSelectedCategory(category: string): void {
    this.selectedCategorySubject.next(category);
  }

}
