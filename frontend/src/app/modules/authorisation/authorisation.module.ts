import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RegformComponent} from "./components/regform/regform.component";

@NgModule({
  declarations: [
    RegformComponent,
  ],
  imports: [
    CommonModule
  ],
  exports:[
    RegformComponent,
  ]
})
export class AuthorisationModule { }
