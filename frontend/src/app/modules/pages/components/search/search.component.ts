import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, NavigationExtras, Router} from "@angular/router";
import {ProductService} from "../../../../services/product-service";
import {ProductModel} from "../../../../models/product-model";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'charging-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public product: ProductModel;
  public loaded: boolean = false;
  public productExists: boolean = false;

  private keyword: string;

  constructor(private activeRoute: ActivatedRoute,
              private productService: ProductService,
              private router: Router,
              private titleService: Title) {
    titleService.setTitle("Search");
  }

  ngOnInit() {
    if(sessionStorage.getItem("search") == null){
      this.router.navigate(['']);
    }
    this.searchProduct();
  }

  private searchProduct():void{
    this.keyword = sessionStorage.getItem("search");
    console.log(this.keyword);
    if(this.keyword){
      this.productService.getProductByName(this.keyword).subscribe(data=>{
        this.product = data;
        if(this.product!= null){
          this.productExists = true;
        }
        setTimeout(()=>{this.loaded = true; sessionStorage.clear()}, 500);
      }, error1 => {
        this.toErrorPage(error1);
      })
    }
  }

  public toErrorPage(error1){
    let nav: NavigationExtras = {
      queryParams:{
        "code": error1.status,
        "message": error1.statusText
      }
    };
    this.router.navigate(['/error'], nav)
  }

}
