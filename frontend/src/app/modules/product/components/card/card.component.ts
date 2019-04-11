import {Component, Input, OnInit} from '@angular/core';
import {ProductModel} from "../../../../models/product-model";

@Component({
  selector: 'charging-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  @Input() product:ProductModel;

  constructor() {
  }

  ngOnInit() {
  }
}
