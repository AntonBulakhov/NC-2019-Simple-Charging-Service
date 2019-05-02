import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ModalsigninComponent} from "./components/modalsignin/modalsignin.component";
import { ModaladdwalletComponent } from './components/modaladdwallet/modaladdwallet.component';
import {RouterModule} from "@angular/router";
import {AuthService} from "../../services/auth-service";
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {AuthInterceptor} from "../../services/auth-interceptor-service";
import {BillingAccountService} from "../../services/billingaccount-service";

@NgModule({
  declarations: [
    ModalsigninComponent,
    ModaladdwalletComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  exports: [
    ModalsigninComponent,
    ModaladdwalletComponent,
  ],
  providers: [
    AuthService,
    AuthInterceptor,
    BillingAccountService,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ]
})
export class ModalsModule { }
