import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../../services/auth-service";
import {NavigationExtras, Router} from "@angular/router";
import file from "../../../../../assets/imgSrc.json"


@Component({
  selector: 'charging-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public srcLink = null;

  public searchString: string;

  constructor(public auth: AuthService,
              private router: Router) { }

  ngOnInit() {
    this.srcLink = file;
  }

  public logOut():void{
    this.auth.logOut();
  }

  public search():void{
    let nav: NavigationExtras = {
      queryParams:{
        "keyword": this.searchString,
      }
    };
    this.router.navigate(['/search'], nav);
    setTimeout(()=>{window.location.reload()}, 100);
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
