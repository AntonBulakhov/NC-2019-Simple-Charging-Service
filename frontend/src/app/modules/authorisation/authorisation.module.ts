import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RegformComponent} from "./components/regform/regform.component";
import {ModalsigninComponent} from "./components/modalsignin/modalsignin.component";

@NgModule({
  declarations: [
    RegformComponent,
    ModalsigninComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    RegformComponent,
    ModalsigninComponent
  ]
})
export class AuthorisationModule { }
