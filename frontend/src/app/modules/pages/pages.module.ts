import { NgModule } from '@angular/core';
import {HomeComponent} from "./components/home/home.component";
import {ProductsComponent} from "./components/products/products.component";
import {RegistrationComponent} from "./components/registration/registration.component";
import {ProductpageComponent} from "./components/productpage/productpage.component";

import {AuthorisationModule} from "../authorisation/authorisation.module";
import {SharedModule} from "../shared/shared.module";

@NgModule({
  declarations: [
    HomeComponent,
    ProductsComponent,
    RegistrationComponent,
    ProductpageComponent
  ],
  imports: [
    AuthorisationModule,
    SharedModule
  ],
  exports:[
    HomeComponent,
    ProductsComponent,
    RegistrationComponent,
    ProductpageComponent
  ]
})
export class PagesModule { }
