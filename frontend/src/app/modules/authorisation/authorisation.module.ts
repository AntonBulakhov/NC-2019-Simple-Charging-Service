import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RegformComponent} from "./components/regform/regform.component";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {UserService} from "../../services/user-service";
import {RoleService} from "../../services/role-service";
import {AuthService} from "../../services/auth-service";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {AuthInterceptor} from "../../services/auth-interceptor-service";

@NgModule({
  declarations: [
    RegformComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  exports:[
    RegformComponent,
  ],
  providers:[
    UserService,
    RoleService,
    AuthService,
    AuthInterceptor,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ]
})
export class AuthorisationModule { }
