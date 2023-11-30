import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/store/category/category.service';
import { ProductsService } from 'src/app/services/store/product/products.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css',
})
export class SidebarComponent implements OnInit {
  productCategory: string[] = [];
  selectedCategory: string;


  constructor(private ps: ProductsService, private cs: CategoryService) {
    this.selectedCategory ='';
  }

  ngOnInit(): void {
    this.ps.getCategories().subscribe(
      (data: string[]) => {
        this.productCategory = data;
      },
      (error) => {
        console.error('error fetching categories');
      }
    );

    this.cs.selectedCategory$.subscribe((category: string) => {
      this.selectedCategory = category;
    });
  }

  selectCategory(category: string){
    this.cs.setSelectedCategory(category);
  }
}
