import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {ProductsComponent} from "./products/products.component";
import {HomeComponent} from "./home/home.component";
import {RegistrationComponent} from "./registration/registration.component";
import {ProductpageComponent} from "./productpage/productpage.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'products', component: ProductsComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'product', component: ProductpageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
