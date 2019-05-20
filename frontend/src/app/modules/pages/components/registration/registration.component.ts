import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {AuthService} from "../../../../services/auth-service";
import {Router} from "@angular/router";

@Component({
  selector: 'charging-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private titleService : Title,
              private auth: AuthService,
              private router: Router) {
    this.titleService.setTitle("Registration");
  }

  ngOnInit() {
  }

}
