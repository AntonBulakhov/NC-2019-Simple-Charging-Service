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
import { NewcompanyComponent } from './components/newcompany/newcompany.component';
import { NewproductComponent } from './components/newproduct/newproduct.component';
import {BrowserModule} from "@angular/platform-browser";
import {ProductService} from "../../services/product-service";
import { NotfoundComponent } from './components/notfound/notfound.component';
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {UserService} from "../../services/user-service";
import {RoleService} from "../../services/role-service";
import {CategoryService} from "../../services/category-service";

@NgModule({
  declarations: [
    HomeComponent,
    ProductsComponent,
    RegistrationComponent,
    ProductpageComponent,
    ProfileComponent,
    UsersComponent,
    CompaniesComponent,
    NewcompanyComponent,
    NewproductComponent,
    NotfoundComponent,
  ],
  imports: [
    AuthorisationModule,
    SharedModule,
    ProductModule,
    ModalsModule,
    BrowserModule,
    RouterModule,
    FormsModule
  ],
  exports:[
    HomeComponent,
    ProductsComponent,
    RegistrationComponent,
    ProductpageComponent,
    ProfileComponent,
    UsersComponent,
    CompaniesComponent,
    NewcompanyComponent,
    NewproductComponent,
    NotfoundComponent
  ],
  providers: [
    ProductService,
    UserService,
    RoleService,
    CategoryService
  ]
})
export class PagesModule { }
