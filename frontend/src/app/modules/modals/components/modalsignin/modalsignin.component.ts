import { Component, OnInit } from '@angular/core';
import {UserModel} from "../../../../models/user-model";
import {AuthService} from "../../../../services/auth-service";

@Component({
  selector: 'charging-modalsignin',
  templateUrl: './modalsignin.component.html',
  styleUrls: ['./modalsignin.component.css']
})
export class ModalsigninComponent implements OnInit {

  public loginUser:UserModel = new UserModel();

  constructor(private auth: AuthService) { }

  ngOnInit() {
  }

  public onSubmit():void{
    this.auth.signIn(this.loginUser);
  }

  public clearInput():void{
    let elements = document.getElementsByTagName("input");
    for (let ii=0; ii < elements.length; ii++) {
      elements[ii].value = "";
    }
  }
}
