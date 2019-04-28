import { NgModule } from '@angular/core';
import {FooterComponent} from "./components/footer/footer.component";
import {NavbarComponent} from "./components/navbar/navbar.component";
import {CarouselComponent} from "./components/carousel/carousel.component";
import {RouterModule} from "@angular/router";
import {AuthService} from "../../services/auth-service";
import {CommonModule} from "@angular/common";

@NgModule({
  declarations: [
    FooterComponent,
    NavbarComponent,
    CarouselComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
  ],
  exports:[
    NavbarComponent,
    FooterComponent,
    CarouselComponent
  ],
  providers: [
    AuthService
  ]
})
export class SharedModule { }
