import { Component, OnInit } from '@angular/core';
import {UserModel} from "../../../../models/user-model";
import {UserService} from "../../../../services/user-service";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'charging-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {
  public users: UserModel[];
  public page: number = 0;
  public pages: Array<number>;

  constructor(private userService: UserService,
              private titleService: Title) {
    this.titleService.setTitle("Companies");
  }

  ngOnInit() {
    this.loadAllCompanies();
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
    this.loadAllCompanies();
  }

  public loadAllCompanies():void{
    this.userService.getAllCompanies(this.page).subscribe(data=>{
      this.pages = new Array<number>(data['totalPages']);
      this.users = data['content'];
    });
  }

}
