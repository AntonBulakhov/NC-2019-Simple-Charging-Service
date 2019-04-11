import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CardComponent} from "./components/card/card.component";
import {RouterModule} from "@angular/router";
import {BrowserModule} from "@angular/platform-browser";

@NgModule({
  declarations: [
    CardComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    BrowserModule
  ],
  exports: [
    CardComponent
  ],
  providers:[
  ]
})
export class ProductModule { }
