import { NgModule } from '@angular/core';
import {FooterComponent} from "./components/footer/footer.component";
import {NavbarComponent} from "./components/navbar/navbar.component";
import {CarouselComponent} from "./components/carousel/carousel.component";
import {RouterModule} from "@angular/router";
import {AuthService} from "../../services/auth-service";
import {CommonModule} from "@angular/common";
import { SpinnerComponent } from './components/spinner/spinner.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    FooterComponent,
    NavbarComponent,
    CarouselComponent,
    SpinnerComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
  ],
  exports: [
    NavbarComponent,
    FooterComponent,
    CarouselComponent,
    SpinnerComponent
  ],
  providers: [
    AuthService
  ]
})
export class SharedModule { }
