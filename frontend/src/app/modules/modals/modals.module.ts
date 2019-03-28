import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ModaltoupComponent} from "./components/modaltoup/modaltoup.component";
import {ModalsigninComponent} from "./components/modalsignin/modalsignin.component";
import { ModaladdwalletComponent } from './components/modaladdwallet/modaladdwallet.component';
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    ModaltoupComponent,
    ModalsigninComponent,
    ModaladdwalletComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    ModaltoupComponent,
    ModalsigninComponent,
    ModaladdwalletComponent
  ]
})
export class ModalsModule { }
