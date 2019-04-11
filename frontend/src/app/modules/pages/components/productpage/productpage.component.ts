import { Component, OnInit } from '@angular/core';
import {ProductModel} from "../../../../models/product-model";
import {Title} from "@angular/platform-browser";
import {ProductService} from "../../../../services/product-service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'charging-productpage',
  templateUrl: './productpage.component.html',
  styleUrls: ['./productpage.component.css']
})
export class ProductpageComponent implements OnInit {

  public product: ProductModel;
  loaded: boolean = false;

  constructor(private titleService: Title,
              private productService: ProductService,
              private activeRoute: ActivatedRoute) { }

  ngOnInit() {
    this.loadProductById();
  }

  private loadProductById():void{
    const id = this.activeRoute.snapshot.params['id'];
    if(id){
      this.productService.getProductById(id).subscribe(productDTO=>{
        this.product = productDTO;
        this.loaded = true;
      })
    }
  }

}
