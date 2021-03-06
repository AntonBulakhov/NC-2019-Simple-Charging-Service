import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {ProductModel} from "../../../../models/product-model";
import {ProductService} from "../../../../services/product-service";

@Component({
  selector: 'charging-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public products: ProductModel[];
  public productsExists: boolean = false;
  public loaded: boolean = false;

  constructor(private titleService : Title,
              private productService: ProductService) {
    this.titleService.setTitle("Home");
  }

  ngOnInit() {
    this.loadTopFourProducts();
  }

  private loadTopFourProducts():void{
    this.productService.getTopFourProducts().subscribe(productsArray =>{
      this.products = productsArray as ProductModel[];
      if (this.products.length != 0){
        this.productsExists = true;
      }else {
        this.productsExists = false;
      }
      setTimeout(()=>{this.loaded = true}, 500);
    })

  }

}
