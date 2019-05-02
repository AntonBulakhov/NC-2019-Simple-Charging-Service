import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, NavigationExtras, Router} from "@angular/router";
import {ProductModel} from "../../../../models/product-model";
import {ProductService} from "../../../../services/product-service";
import {BillingAccountService} from "../../../../services/billingaccount-service";
import {Title} from "@angular/platform-browser";
import {AuthService} from "../../../../services/auth-service";
import {BillingAccountModel} from "../../../../models/billingaccount-model";
import {SubscriptionModel} from "../../../../models/subscription-model";
import file from "../../../../../assets/imgSrc.json"
import {SubscriptionService} from "../../../../services/subscription-service";

@Component({
  selector: 'app-subscribe',
  templateUrl: './subscribe.component.html',
  styleUrls: ['./subscribe.component.css']
})
export class SubscribeComponent implements OnInit {

  public product: ProductModel;
  public wallets: BillingAccountModel[];

  public walletName: string;
  public month: number;

  public loaded: boolean = false;
  public imgLink;

  public newSubscribtion: SubscriptionModel = new SubscriptionModel();

  constructor( private activeRoute: ActivatedRoute,
               private productService: ProductService,
               private baService: BillingAccountService,
               private router: Router,
               private titleService: Title,
               public auth: AuthService,
               public subService: SubscriptionService) { }

  ngOnInit() {
    this.imgLink = file;
    this.loadProductById();
  }

  public onSubmit():void{
    this.newSubscribtion.product = this.product;
    this.newSubscribtion.billingAccount = this.findWalletByName();
    this.newSubscribtion.blocked = "0";
    this.newSubscribtion.time = this.month;

    switch (this.month) {
      case 1: {
        this.newSubscribtion.discount = 0;
        break;
      }
      case 3:{
        this.newSubscribtion.discount = 5;
        break;
      }
      case 6:{
        this.newSubscribtion.discount = 10;
        break;
      }
      case 12:{
        this.newSubscribtion.discount = 20;
        break;
      }
    }

    this.subService.createSubscription(this.newSubscribtion).subscribe(()=>{
      this.router.navigate(['/']);
    }, error1 => {
      this.toErrorPage(error1);
    })
  }

  findWalletByName():BillingAccountModel{
    return this.wallets.find(obj=> obj.name == this.walletName);
  }

  public loadProductById():void{
    const id = this.activeRoute.snapshot.params['id'];
    if(id){
      this.productService.getProductById(id).subscribe(value=>{
        this.product = value;

        this.baService.getWalletsByUserId(this.auth.user.id).subscribe(data=>{
          this.wallets = data as BillingAccountModel[];
          this.walletName = this.wallets[0].name;
          this.month = 1;
          this.loaded = true;
        })
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
