import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Products } from 'src/app/model/products';
import { CategoryService } from 'src/app/services/store/category/category.service';
import { ProductsService } from 'src/app/services/store/product/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  products: Products[] = [];
  selectedCategory: string = '';
  filteredProducts: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private ps: ProductsService,
    private cs: CategoryService
  ) {}
  ngOnInit(): void {
    this.ps.getProducts().subscribe(
      (data: Products[]) => {
        this.products = data;
        this.filteredProducts = this.products; //taking the product data to be filtered
      },
      (error) => {
        console.error('Error fetching products from server', error);
      }
    );

    this.cs.selectedCategory$.subscribe((category: string) => {
      this.selectedCategory = category;
      this.filterProductsByCategory(); //filters products based on selected category
    });
  }

  private filterProductsByCategory() {
    this.filteredProducts = this.selectedCategory
      ? this.products.filter((p) => p.category === this.selectedCategory)
      : this.products;
  }
}
