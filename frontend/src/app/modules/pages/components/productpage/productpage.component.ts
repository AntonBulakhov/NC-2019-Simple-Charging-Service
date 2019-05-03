import { Component, OnInit } from '@angular/core';
import {ProductModel} from "../../../../models/product-model";
import {Title} from "@angular/platform-browser";
import {ProductService} from "../../../../services/product-service";
import {ActivatedRoute, Router} from "@angular/router";
import file from "../../../../../assets/imgSrc.json"
import {AuthService} from "../../../../services/auth-service";

@Component({
  selector: 'charging-productpage',
  templateUrl: './productpage.component.html',
  styleUrls: ['./productpage.component.css']
})
export class ProductpageComponent implements OnInit {

  public product: ProductModel;
  loaded: boolean = false;
  notAuth: boolean;
  isSeller: boolean;

  public imgLink;

  constructor(private titleService: Title,
              private productService: ProductService,
              private activeRoute: ActivatedRoute,
              private auth: AuthService,
              private router: Router) {
    titleService.setTitle("Product")
  }

  ngOnInit() {
    this.loadProductById();
  }

  private loadProductById():void{
    this.imgLink = file;
    const id = this.activeRoute.snapshot.params['id'];
    if(id){
      this.productService.getProductById(id).subscribe(productDTO=>{
        this.product = productDTO;
        setTimeout(()=>{this.loaded = true}, 500);
      })
    }
  }

  public onBuy(){
    if(this.auth.user != null){
      if(this.auth.user.role.name!='seller'){
        this.router.navigate(['/subscribe/'+this.product.id]);
      }else {
        this.isSeller = true;
      }
    }else {
      this.notAuth = true;
    }
  }

}
