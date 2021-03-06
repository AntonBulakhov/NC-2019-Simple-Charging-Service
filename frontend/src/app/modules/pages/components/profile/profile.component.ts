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

  //to delete product
  public productToDelete: string;
  public subsCountOnProduct: number = 0;

  //to delete wallet
  public walletToDelete: string;

  //to delete subscription
  public subToDelete: string;

  loaded: boolean = false;
  maxWallets: boolean = false;

  public selectedSub: SubscriptionModel = new SubscriptionModel();
  public  selectedWallet: number;
  public sum: number;

  walletsExists: boolean = false;
  subsExists: boolean = false;
  productsExists: boolean = false;

  public imgLink;

  constructor(public auth: AuthService,
              private titleService: Title,
              private activeRoute: ActivatedRoute,
              private userService: UserService,
              private router: Router,
              private baService: BillingAccountService,
              private productService: ProductService,
              private subsService: SubscriptionService) {
    titleService.setTitle("Profile");
  }

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
            if(this.subscriptions != null){
              this.subsExists = true;
            }else{
              this.subsExists = false;
            }

            this.baService.getWalletsByUserId(id).subscribe(data=>{
              this.wallets = data as BillingAccountModel[];
              if(this.wallets != null){
                if(this.wallets.length >= 3){
                  this.maxWallets = true;
                }
                if(this.wallets.length != 0){
                  this.walletsExists = true;
                }
              }
              setTimeout(()=>{this.loaded = true}, 500);
            });
          });
        }else {
          this.productService.getProductByUser(this.profileUser.id).subscribe(data=>{
            this.products = data as ProductModel[];
            if(this.products.length != 0){
              this.productsExists = true;
            }
            setTimeout(()=>{this.loaded = true}, 500);
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

  public buyMore(selectedId: string):void{
    this.selectedSub = SubscriptionModel.cloneBase(this.subscriptions.find(obj=> obj.id == selectedId));
    this.selectedSub.time = 1;
  }

  public buyMoreSub():void{
    this.subsService.buyMoreSub(this.selectedSub).subscribe(value => {
      setTimeout(location.reload.bind(location), 200);
    }, error1 => {

    })
  }

  //delete wallet
  public setWalletToDelete(id: string):void{
    this.walletToDelete = id;
  }

  public deleteWallet():void{
    this.baService.deleteWallet(this.walletToDelete).subscribe(()=>{
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

  //delete product
  public setProductToDelete(id: string):void{
    this.productToDelete = id;
    this.subsService.getSubsCountByPRoduct(id).subscribe(value => {
      this.subsCountOnProduct = value;
    })
  }

  public deleteProduct():void{
    this.productService.deleteProduct(this.productToDelete).subscribe(()=>{
      setTimeout(location.reload.bind(location), 200);
    });
  }

  //block user
  public blockUser():void{
    this.userService.blockUser(this.profileUser.id).subscribe(()=>{
      setTimeout(location.reload.bind(location), 200);
    });
  }

  public unblockUser():void{
    this.userService.unblockUser(this.profileUser.id).subscribe(()=>{
      setTimeout(location.reload.bind(location), 200);
    });
  }

  //delete subscription
  public unsub(): void{
    this.subsService.deleteSubscription(this.findSubId(this.subToDelete)).subscribe(() => {
      setTimeout(location.reload.bind(location), 200);
    }, error=>{

    });
  }

  private findSubId(name: string): string{
    return this.subscriptions.find(obj=> obj.product.name == name).id;
  }

  public setUnsub(sub: string){
    this.subToDelete = sub;
  }
}
