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

  public products: ProductModel[];

  constructor(private titleService : Title,
              private productService: ProductService) {
    this.titleService.setTitle("Products")
  }

  ngOnInit() {
    this.loadAllProducts();
  }

  private loadAllProducts(): void{
    this.productService.getAllProducts().subscribe(productsArray =>{
      this.products = productsArray as ProductModel[];
    })
  }

}
