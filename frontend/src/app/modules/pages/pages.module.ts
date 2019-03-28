import { NgModule } from '@angular/core';

import {HomeComponent} from "./components/home/home.component";
import {ProductsComponent} from "./components/products/products.component";
import {RegistrationComponent} from "./components/registration/registration.component";
import {ProductpageComponent} from "./components/productpage/productpage.component";
import {AuthorisationModule} from "../authorisation/authorisation.module";
import {SharedModule} from "../shared/shared.module";
import {ProductModule} from "../product/product.module";
import { ProfileComponent } from './components/profile/profile.component';
import {ModalsModule} from "../modals/modals.module";
import { UsersComponent } from './components/users/users.component';
import { CompaniesComponent } from './components/companies/companies.component';
import { RegnewcompanyComponent } from './components/regnewcompany/regnewcompany.component';
import { AddnewproductComponent } from './components/addnewproduct/addnewproduct.component';

@NgModule({
  declarations: [
    HomeComponent,
    ProductsComponent,
    RegistrationComponent,
    ProductpageComponent,
    ProfileComponent,
    UsersComponent,
    CompaniesComponent,
    RegnewcompanyComponent,
    AddnewproductComponent,
  ],
  imports: [
    AuthorisationModule,
    SharedModule,
    ProductModule,
    ModalsModule,
  ],
  exports:[
    HomeComponent,
    ProductsComponent,
    RegistrationComponent,
    ProductpageComponent,
    ProfileComponent,
    UsersComponent,
    CompaniesComponent,
    RegnewcompanyComponent,
    AddnewproductComponent
  ]
})
export class PagesModule { }
