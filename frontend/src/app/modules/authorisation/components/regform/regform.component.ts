import { Component, OnInit } from '@angular/core';
import {UserModel} from "../../../../models/user-model";
import {RoleModel} from "../../../../models/role-model";
import {RoleService} from "../../../../services/role-service";
import {UserService} from "../../../../services/user-service";
import {Router} from "@angular/router";

@Component({
  selector: 'charging-regform',
  templateUrl: './regform.component.html',
  styleUrls: ['./regform.component.css']
})
export class RegformComponent implements OnInit {

  public newUser: UserModel = new UserModel();
  public isAdmin: boolean = false;
  public roles: RoleModel[];

  constructor(private roleService: RoleService,
              private userService: UserService,
              private router: Router) { }

  ngOnInit() {
    this.roleService.getAllRoles().subscribe(roles=>{
      this.roles = roles as RoleModel[];
    })
  }

  public regNewUser():void{
    this.newUser.logoUrl = "userlogo.jpg";
    this.newUser.role = this.getRole();
    this.userService.regNewUser(this.newUser).subscribe(()=>{
      this.router.navigate(['']);
    },
      error => {
      this.router.navigate(['/404'])
      });
  }

  public getRole():RoleModel{
    if(!this.isAdmin){
      return this.roles.find(obj=> obj.name == "user");
    }else {
      return this.roles.find(obj=> obj.name == "admin");
    }
  }

}
