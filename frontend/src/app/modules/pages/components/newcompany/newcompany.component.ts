import { Component, OnInit } from '@angular/core';
import {UserModel} from "../../../../models/user-model";
import {ProductModel} from "../../../../models/product-model";

@Component({
  selector: 'charging-regnewcompany',
  templateUrl: './newcompany.component.html',
  styleUrls: ['./newcompany.component.css']
})
export class NewcompanyComponent implements OnInit {

  public user: UserModel;
  public newProduct: ProductModel;

  constructor() { }

  ngOnInit() {
  }

}
