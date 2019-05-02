import { Component, OnInit } from '@angular/core';
import {UserModel} from "../../../../models/user-model";
import {AuthService} from "../../../../services/auth-service";
import {Title} from "@angular/platform-browser";
import {ActivatedRoute, NavigationExtras, Router} from "@angular/router";
import {UserService} from "../../../../services/user-service";
import {BillingAccountService} from "../../../../services/billingaccount-service";
import {BillingAccountModel} from "../../../../models/billingaccount-model";
import {ProductModel} from "../../../../models/product-model";
import {ProductService} from "../../../../services/product-service";
import file from "../../../../../assets/imgSrc.json"
import {SubscriptionService} from "../../../../services/subscription-service";
import {SubscriptionModel} from "../../../../models/subscription-model";

@Component({
  selector: 'charging-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public profileUser: UserModel;

  //if user profile
  public subscriptions: SubscriptionModel[];
  public wallets: BillingAccountModel[];

  //if company profile
  public products: ProductModel[];

  loaded: boolean = false;
  maxWallets: boolean = false;

  public  selectedWallet: number;
  public sum: number;

  walletsExists: boolean = false;
  productsExists: boolean = false;

  public imgLink;

  constructor(public auth: AuthService,
              private titleService: Title,
              private activeRoute: ActivatedRoute,
              private userService: UserService,
              private router: Router,
              private baService: BillingAccountService,
              private productService: ProductService,
              private subsService: SubscriptionService) { }

  ngOnInit() {
    this.loadUserById();
  }

  private loadUserById():void{
    const id = this.activeRoute.snapshot.params['id'];
    if(id){
      this.userService.getUSerById(id).subscribe(data=>{
        this.profileUser = data;
        this.imgLink = file;

        if(this.profileUser.role.name != "seller"){
          this.subsService.getSubsByUser(id).subscribe(data=>{
            this.subscriptions = data as SubscriptionModel[];

            this.baService.getWalletsByUserId(id).subscribe(data=>{
              this.wallets = data as BillingAccountModel[];
              if(this.wallets.length >= 3){
                this.maxWallets = true;
              }
              if(this.wallets.length != 0){
                this.walletsExists = true;
              }
              this.loaded = true;
            });
          });
        }else {
          this.productService.getProductByUser(this.profileUser.id).subscribe(data=>{
            this.products = data as ProductModel[];
            if(this.products.length != 0){
              this.productsExists = true;
            }
            this.loaded = true;
          })
        }
      }, error1 => {
        let nav: NavigationExtras = {
          queryParams:{
            "code": error1.status,
            "message": error1.statusText
          }
        };
        this.router.navigate(['/error'], nav)
      });
    }
  }

  public onSubmitToUp():void{
    this.wallets[this.selectedWallet].sum += Number(this.sum);
    this.baService.updateWallet(this.wallets[this.selectedWallet]).subscribe(()=>{
      this.wallets = null;
      setTimeout(location.reload.bind(location), 100);
    }, error1 => {
      let nav: NavigationExtras = {
        queryParams:{
          "code": error1.status,
          "message": error1.statusText
        }
      };
      this.router.navigate(['/error'], nav);
      setTimeout(location.reload.bind(location), 100);
    });
  }

  public deleteWallet(id: number):void{
    this.baService.deleteWallet(this.wallets[id]).subscribe(()=>{
      setTimeout(location.reload.bind(location), 100);
    }, error1 =>{
      let nav: NavigationExtras = {
        queryParams:{
          "code": error1.status,
          "message": error1.statusText
        }
      };
      this.router.navigate(['/error'], nav);
    });
  }

}
