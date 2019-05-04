import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {ProductModel} from "../../../../models/product-model";
import {ProductService} from "../../../../services/product-service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'charging-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  public page: number = 0;
  public products: ProductModel[];
  public pages: Array<number>;


  public productsExists: boolean;
  public loaded: boolean = false;

  public orderParam: string = null;
  public filterParam: string = null;


  constructor(private titleService : Title,
              private productService: ProductService,
              private route: ActivatedRoute) {
    this.titleService.setTitle("Products")
  }

  ngOnInit() {
    this.loadAllProducts();
  }

  private loadAllProducts(): void{
    this.loaded = false;
    this.products = null;
    this.pages = null;

    this.orderParam = null;
    this.filterParam = null;

    this.productService.getAllProducts(this.page, this.orderParam, this.filterParam).subscribe(data =>{
      this.products = data['content'];
      this.pages = new Array<number>(data['totalPages']);
      if (this.products.length != 0){
        this.productsExists = true;
      }else {
        this.productsExists = false;
      }
      setTimeout(()=>{this.loaded = true}, 500);
    });
  }

  public lowestPrice():void{
    this.loaded = false;
    this.products = null;
    this.pages = null;
    this.orderParam = 'lprice';

    this.productService.getAllProducts(0, this.orderParam, this.filterParam).subscribe(data =>{
      this.products = data['content'];
      this.pages = new Array<number>(data['totalPages']);
      if (this.products.length != 0){
        this.productsExists = true;
      }else {
        this.productsExists = false;
      }
      setTimeout(()=>{this.loaded = true}, 500);
    });
  }

  public highestPrice():void{
    this.loaded = false;
    this.products = null;
    this.pages = null;
    this.orderParam = 'hprice';

    this.productService.getAllProducts(0, this.orderParam, this.filterParam).subscribe(data =>{
      this.products = data['content'];
      this.pages = new Array<number>(data['totalPages']);
      if (this.products.length != 0){
        this.productsExists = true;
      }else {
        this.productsExists = false;
      }
      setTimeout(()=>{this.loaded = true}, 500);
    });
  }

  public loadFilter(param: string):void{
    this.loaded = false;
    this.products = null;
    this.pages = null;

    this.filterParam = param;

    this.productService.getAllProducts(0, this.orderParam, this.filterParam).subscribe(data =>{
      this.products = data['content'];
      this.pages = new Array<number>(data['totalPages']);
      if (this.products.length != 0){
        this.productsExists = true;
      }else {
        this.productsExists = false;
      }
      setTimeout(()=>{this.loaded = true}, 500);
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
}
