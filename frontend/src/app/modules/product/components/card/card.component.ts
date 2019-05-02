import {Component, Input, OnInit} from '@angular/core';
import {ProductModel} from "../../../../models/product-model";
import file from "../../../../../assets/imgSrc.json"

@Component({
  selector: 'charging-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  @Input() product:ProductModel;
  public loaded: boolean = false;
  public srcLink = null;

  constructor() {
  }

  ngOnInit() {
    this.srcLink = file;
    this.loaded = true;
  }
}
