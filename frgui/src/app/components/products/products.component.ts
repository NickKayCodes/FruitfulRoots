import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Products } from 'src/app/model/products';
import { ProductsService } from 'src/app/services/store/product/products.service';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  products: Products[] = [];
  productCategory: string[] = [];

  constructor(
    private route: ActivatedRoute,
    private ps: ProductsService,
    private cdr: ChangeDetectorRef
  ) {}
  ngOnInit(): void {
    this.ps.getProducts().subscribe(
      (data: Products[]) => {
        this.products = data;
        console.log(this.products)
      },
      (error) => {
        console.error('Error fetching products from server', error);
      }
    );
  }
}
