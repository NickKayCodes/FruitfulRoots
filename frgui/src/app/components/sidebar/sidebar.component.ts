import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css',
})
export class SidebarComponent implements OnInit {
  productCategory: string[] = [];

  ngOnInit(): void {
          this.ps.getCategories().subscribe(
            (data: string[]) => {
              this.productCategory = data;
            },
            (error) => {
              console.error('error fetching categories');
            }
          );
  }
}
