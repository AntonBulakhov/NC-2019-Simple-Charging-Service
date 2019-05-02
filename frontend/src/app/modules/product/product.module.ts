import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CardComponent} from "./components/card/card.component";
import {RouterModule} from "@angular/router";
import {BrowserModule} from "@angular/platform-browser";
import {AuthService} from "../../services/auth-service";
import {ModalsModule} from "../modals/modals.module";

@NgModule({
  declarations: [
    CardComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    BrowserModule,
    ModalsModule
  ],
  exports: [
    CardComponent
  ],
  providers:[
    AuthService
  ]
})
export class ProductModule { }
