import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {ProductModel} from "../../../../models/product-model";
import {ProductService} from "../../../../services/product-service";

@Component({
  selector: 'charging-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  public page: number = 0;
  public products: ProductModel[];
  public pages: Array<number>;

  public productsExists: boolean = false;

  constructor(private titleService : Title,
              private productService: ProductService) {
    this.titleService.setTitle("Products")
  }

  ngOnInit() {
    this.loadAllProducts();
  }

  private loadAllProducts(): void{
    this.productService.getAllProducts(this.page).subscribe(data =>{
      this.products = data['content'];
      this.pages = new Array<number>(data['totalPages']);
      if (this.products.length != 0){
        this.productsExists = true;
      }
    });
  }

  public setPage(i, event: any){
    event.preventDefault();
    if (i < 0) {
      this.page = this.pages.length-1;
    } else if(i > this.pages.length-1){
      this.page = 0;
    }else {
      this.page = i;
    }
    this.loadAllProducts();
  }

  public _getBlocked(number: string): string{
    if(number == "0") return "No";
    else return "Yes";
  }
}
