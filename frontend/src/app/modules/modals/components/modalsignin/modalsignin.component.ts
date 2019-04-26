import { Component, OnInit } from '@angular/core';
import {UserModel} from "../../../../models/user-model";

@Component({
  selector: 'charging-modalsignin',
  templateUrl: './modalsignin.component.html',
  styleUrls: ['./modalsignin.component.css']
})
export class ModalsigninComponent implements OnInit {

  public user:UserModel;

  constructor() { }

  ngOnInit() {
  }

}
