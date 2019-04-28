import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../../services/auth-service";
import {NavigationExtras, Router} from "@angular/router";
import {UserService} from "../../../../services/user-service";
import {UserModel} from "../../../../models/user-model";
import {RoleService} from "../../../../services/role-service";
import {RoleModel} from "../../../../models/role-model";

@Component({
  selector: 'charging-regnewcompany',
  templateUrl: './newcompany.component.html',
  styleUrls: ['./newcompany.component.css']
})
export class NewcompanyComponent implements OnInit {

  public newSeller: UserModel = new UserModel();
  public roles: RoleModel[];

  public sellerImage: File = null;

  public userExistsByEmail: boolean = false;
  public userExistsByLogin: boolean = false;

  constructor(public auth: AuthService,
              private userService: UserService,
              private router: Router,
              private roleService: RoleService) { }

  ngOnInit() {
    this.roleService.getAllRoles().subscribe(roles=>{
      this.roles = roles as RoleModel[];
    })
  }

  public onChange(files): void{
    this.sellerImage = files[0];
  }

  public regNewSeller():void{
    if(!this.userExistsByEmail && !this.userExistsByLogin){
      this.newSeller.role = this.getRole();
      this.newSeller.logoUrl = this.newSeller.login + "-logo.jpg".trim();

      this.userService.saveUserImage(this.sellerImage, this.newSeller.logoUrl).subscribe(()=>{
        this.userService.saveNewUser(this.newSeller).subscribe(resp=>{
          let user: UserModel = resp as UserModel;
          this.router.navigate(['/profile/'+user.id]);
        }, error1 => {
          let nav: NavigationExtras = {
            queryParams:{
              "code": error1.status,
              "message": error1.statusText
            }
          };
          this.router.navigate(['/error'], nav)
        })
      });
    }
  }

  public getRole():RoleModel{
    return this.roles.find(obj=> obj.name == "seller");
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
