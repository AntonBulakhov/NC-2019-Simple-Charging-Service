import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-errorpage',
  templateUrl: './errorpage.component.html',
  styleUrls: ['./errorpage.component.css']
})
export class ErrorpageComponent implements OnInit {

  public errorStatus;
  public errorMessage;

  constructor(private route: ActivatedRoute) {
    route.queryParams.subscribe(param=>{
      this.errorStatus = param['code'];
      this.errorMessage = param['message'];
    })
  }

  ngOnInit() {
  }

}
