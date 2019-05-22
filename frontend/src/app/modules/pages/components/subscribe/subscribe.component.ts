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
import {error} from "@angular/compiler/src/util";

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

  hasWallets: boolean = false;
  notEnoughMoney: boolean = false;

  public subAlreadyExists: boolean;

  public newSubscription: SubscriptionModel = new SubscriptionModel();

  constructor( private activeRoute: ActivatedRoute,
               private productService: ProductService,
               private baService: BillingAccountService,
               private router: Router,
               private titleService: Title,
               public auth: AuthService,
               public subService: SubscriptionService) {
    titleService.setTitle("Subscribe");
  }

  ngOnInit() {
    if(this.auth.user == null || this.auth.user.role.name == "seller"){
      this.router.navigate(['']);
    }else {
      this.imgLink = file;
      this.loadProductById();
    }
  }

  public onSubmit():void{
    this.newSubscription.product = this.product;
    this.newSubscription.billingAccount = this.findWalletByName();
    if(this.newSubscription.billingAccount.sum < +this.product.price){
      this.notEnoughMoney = true;
    }else {
      this.newSubscription.blocked = "0";
      this.newSubscription.time = this.month;

      switch (+this.month) {
        case 1:
          this.newSubscription.discount = 0;
          break;
        case 3:
          this.newSubscription.discount = 5;
          break;
        case 6:
          this.newSubscription.discount = 10;
          break;
        case 12:
          this.newSubscription.discount = 20;
          break;
        default:
          this.newSubscription.discount = 0;
      }

      this.subService.createSubscription(this.newSubscription).subscribe(()=>{
        this.router.navigate(['/']);
      }, error1 => {
        this.toErrorPage(error1);
      })
    }
  }

  public findWalletByName():BillingAccountModel{
    return this.wallets.find(obj=> obj.name == this.walletName);
  }

  public loadProductById():void{
    const id = this.activeRoute.snapshot.params['id'];
    if(id){
      this.productService.getProductById(id).subscribe(value=>{
        this.product = value;

        this.subService.checkSubscriptionExists(this.auth.user.id, this.product.id).subscribe(data=>{
          this.subAlreadyExists = data;

          this.baService.getWalletsByUserId(this.auth.user.id).subscribe(data=>{
            this.wallets = data as BillingAccountModel[];
            if(this.wallets == null){
              this.hasWallets = false;
            }else {
              this.hasWallets = true;
              this.walletName = this.wallets[0].name;
              this.month = 1;
            }

            setTimeout(()=>{this.loaded = true}, 500);
          }, error1 => {
            this.toErrorPage(error1);
          })
        }, error1=>{
          this.toErrorPage(error1);
        });
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
