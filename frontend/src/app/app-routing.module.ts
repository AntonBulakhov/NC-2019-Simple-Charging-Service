import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {ProductsComponent} from "./modules/pages/components/products/products.component";
import {HomeComponent} from "./modules/pages/components/home/home.component";
import {RegistrationComponent} from "./modules/pages/components/registration/registration.component";
import {ProductpageComponent} from "./modules/pages/components/productpage/productpage.component";

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
