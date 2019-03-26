import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {CardComponent} from "./card/card.component";
import {ProductpageComponent} from "./modules/pages/components/productpage/productpage.component";
import {PagesModule} from "./modules/pages/pages.module";


@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    ProductpageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    PagesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
