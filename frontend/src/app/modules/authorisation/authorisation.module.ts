import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RegformComponent} from "./components/regform/regform.component";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {UserService} from "../../services/user-service";
import {RoleService} from "../../services/role-service";

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
    RoleService
  ]
})
export class AuthorisationModule { }
