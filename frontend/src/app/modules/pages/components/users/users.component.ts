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
    this.userService.getAllUsers(this.page).subscribe(data=>{
      this.pages = new Array<number>(data['totalPages']);
      this.users = data['content'];
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
