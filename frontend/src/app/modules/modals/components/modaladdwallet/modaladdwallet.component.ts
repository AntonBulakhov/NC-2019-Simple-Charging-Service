import { Component, OnInit } from '@angular/core';
import {BillingAccountModel} from "../../../../models/billingaccount-model";
import {BillingAccountService} from "../../../../services/billingaccount-service";
import {AuthService} from "../../../../services/auth-service";
import {NavigationExtras, Router} from "@angular/router";

@Component({
  selector: 'charging-modaladdwallet',
  templateUrl: './modaladdwallet.component.html',
  styleUrls: ['./modaladdwallet.component.css']
})
export class ModaladdwalletComponent implements OnInit {

  public newWallet: BillingAccountModel = new BillingAccountModel();
  public walletNameExists = false;

  constructor(private baService: BillingAccountService,
              public auth: AuthService,
              private router: Router) { }

  ngOnInit() {
  }

  public onSubmit():void{
    if(!this.walletNameExists){
      this.newWallet.sum = 0;
      this.newWallet.user = this.auth.user;
      this.baService.createNewWallet(this.newWallet).subscribe(()=>{
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
      })
    }
  }

  public walletNameCheck(name: string):void{
    if(name != undefined){
      this.baService.walletCheckByName(name, this.auth.user).subscribe(value=>{
        this.walletNameExists = value;
      })
    }
  }

}
