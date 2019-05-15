import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../../services/user-service";
import {UserModel} from "../../../../models/user-model";
import {Title} from "@angular/platform-browser";
import {NavigationExtras, Router} from "@angular/router";

@Component({
  selector: 'charging-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  public users: UserModel[];
  public page: number = 0;
  public pages: Array<number>;

  public loaded: boolean = false;

  private filter: string = null;

  constructor(private userService: UserService,
              private titleService: Title,
              private router: Router) {
    this.titleService.setTitle("Users");
  }

  ngOnInit() {
    this.loadAllUsers();
  }

  public setPage(i, event: any){
    event.preventDefault();
    if (i < 0) {
      this.page = this.pages.length-1;
    } else if(i > this.pages.length-1){
      this.page = 0;
    }else {
      this.page = i;
    }
    this.loadAllUsers();
  }

  public loadAllUsers(): void{
    this.loaded = false;
    this.users = null;
    this.pages = null;

    this.filter = null;

    this.userService.getAllUsers(this.page, this.filter).subscribe(data=>{
      this.pages = new Array<number>(data['totalPages']);
      this.users = data['content'];

      setTimeout(()=>{this.loaded = true}, 500);
    }, error1 => {
      let nav: NavigationExtras = {
        queryParams:{
          "code": error1.status,
          "message": error1.statusText
        }
      };
      this.router.navigate(['/error'], nav)
    });
  }

  public loadOnlyAdmins():void{
    this.loaded = false;
    this.users = null;
    this.pages = null;

    this.filter = "admins";

    this.userService.getAllUsers(this.page, this.filter).subscribe(data=>{
      this.pages = new Array<number>(data['totalPages']);
      this.users = data['content'];

      setTimeout(()=>{this.loaded = true}, 500);
    }, error1 => {
      let nav: NavigationExtras = {
        queryParams:{
          "code": error1.status,
          "message": error1.statusText
        }
      };
      this.router.navigate(['/error'], nav)
    });
  }

  public loadOnlyUsers():void{
    this.loaded = false;
    this.users = null;
    this.pages = null;

    this.filter = "users";

    this.userService.getAllUsers(this.page, this.filter).subscribe(data=>{
      this.pages = new Array<number>(data['totalPages']);
      this.users = data['content'];

      setTimeout(()=>{this.loaded = true}, 500);
    }, error1 => {
      let nav: NavigationExtras = {
        queryParams:{
          "code": error1.status,
          "message": error1.statusText
        }
      };
      this.router.navigate(['/error'], nav)
    });
  }

  public loadOnlyBlocked():void{
    this.loaded = false;
    this.users = null;
    this.pages = null;

    this.filter = "blocked";

    this.userService.getAllUsers(this.page, this.filter).subscribe(data=>{
      this.pages = new Array<number>(data['totalPages']);
      this.users = data['content'];

      setTimeout(()=>{this.loaded = true}, 500);
    }, error1 => {
      let nav: NavigationExtras = {
        queryParams:{
          "code": error1.status,
          "message": error1.statusText
        }
      };
      this.router.navigate(['/error'], nav)
    });
  }

}
