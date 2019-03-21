import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { NavbarComponent } from './navbar/navbar.component';
import { ModalsigninComponent } from './modalsignin/modalsignin.component';
import { CarouselComponent } from './carousel/carousel.component';
import { CardComponent } from './card/card.component';
import { FooterComponent } from './footer/footer.component';
import { ProductsComponent } from './products/products.component';
import { HomeComponent } from './home/home.component';
import { RegistrationComponent } from './registration/registration.component';
import { RegformComponent } from './regform/regform.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ModalsigninComponent,
    CarouselComponent,
    CardComponent,
    FooterComponent,
    ProductsComponent,
    HomeComponent,
    RegistrationComponent,
    RegformComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
