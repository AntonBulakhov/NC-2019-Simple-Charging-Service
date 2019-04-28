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

}
