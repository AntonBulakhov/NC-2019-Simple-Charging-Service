import { NgModule } from '@angular/core';
import {FooterComponent} from "./components/footer/footer.component";
import {NavbarComponent} from "./components/navbar/navbar.component";
import {CarouselComponent} from "./components/carousel/carousel.component";

@NgModule({
  declarations: [
    FooterComponent,
    NavbarComponent,
    CarouselComponent
  ],
  imports: [
  ],
  exports:[
    NavbarComponent,
    FooterComponent,
    CarouselComponent
  ]
})
export class SharedModule { }
