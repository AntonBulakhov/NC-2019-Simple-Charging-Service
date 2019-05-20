import {Component, Input, OnInit} from '@angular/core';
import {UserModel} from "../../../../models/user-model";
import {RoleModel} from "../../../../models/role-model";
import {RoleService} from "../../../../services/role-service";
import {UserService} from "../../../../services/user-service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../../services/auth-service";

@Component({
  selector: 'charging-regform',
  templateUrl: './regform.component.html',
  styleUrls: ['./regform.component.css']
})
export class RegformComponent implements OnInit {

  public newUser: UserModel = new UserModel();
  public isAdmin: boolean = false;
  public roles: RoleModel[];
  public userExistsByEmail: boolean = false;
  public userExistsByLogin: boolean = false;

  public emptyFields: boolean = false;

  constructor(private roleService: RoleService,
              private userService: UserService,
              private router: Router,
              private auth: AuthService,
              private route: ActivatedRoute) {

    route.queryParams.subscribe(param=>{
      if(param['isA']){
        this.isAdmin = true;
      }
      if( this.auth.user != null && !this.isAdmin){
        this.router.navigate(['']);
      }
    })
  }

  ngOnInit() {

    this.roleService.getAllRoles().subscribe(roles=>{
      this.roles = roles as RoleModel[];
    })
  }

  public regNewUser():void{
    if(!this.userExistsByEmail && !this.userExistsByLogin){
      if (this.newUser.email != null|| this.newUser.login!=null||this.newUser.password != null|| this.newUser.firstname != null||
      this.newUser.secondname!=null) {
        this.newUser.logoUrl = "default-logo.jpg";
        this.newUser.role = this.getRole();
        this.auth.signUp(this.newUser);
      }else {
        this.emptyFields = true;
      }
    }
  }

  public getRole():RoleModel{
    if(!this.isAdmin){
      return this.roles.find(obj=> obj.name == "user");
    }else {
      return this.roles.find(obj=> obj.name == "admin");
    }
  }

  public ifExistsByEmail(email: string):void{
    if(email != undefined) this.userService.findUserByEmail(email).subscribe((exists)=>{
      if(exists) {
        this.userExistsByEmail = true;
      }
    });
  }

  public ifExistsByLogin(login: string):void{
    if(login != undefined) this.userService.findUserByLogin(login).subscribe((exists)=>{
      if(exists) {
        this.userExistsByLogin = true;
      }
    })
  }
}
