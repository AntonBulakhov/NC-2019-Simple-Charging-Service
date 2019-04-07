import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'charging-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit() {
  }

  getUser():void{
    this.http.get("/api/user/login/user").subscribe(value => {
      console.log(value);
    })
  }
}
