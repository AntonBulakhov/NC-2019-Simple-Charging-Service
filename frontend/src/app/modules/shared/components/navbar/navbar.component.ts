import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../../services/auth-service";
import {NavigationExtras, Router} from "@angular/router";

@Component({
  selector: 'charging-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(public auth: AuthService,
              private router: Router) { }

  ngOnInit() {
  }

  public logOut():void{
    this.auth.logOut();
  }

  public regNewAdmin(){
    let nav: NavigationExtras = {
      queryParams:{
        "isA": true,
      }
    };
    this.router.navigate(['/registration'], nav)
  }
}
