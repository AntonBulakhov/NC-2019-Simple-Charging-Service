import {Component, Input, OnInit} from '@angular/core';
import {ProductModel} from "../../../../models/product-model";
import file from "../../../../../assets/imgSrc.json"
import {AuthService} from "../../../../services/auth-service";
import {Router} from "@angular/router";

@Component({
  selector: 'charging-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  @Input() product:ProductModel;
  public loaded: boolean = false;
  public srcLink = null;

  public notAuth: boolean;
  public isSeller: boolean;

  constructor(private auth: AuthService,
              private router: Router) {
  }

  ngOnInit() {
    this.srcLink = file;
    this.loaded = true;
  }

  onBuy(){
    if(this.auth.user != null){
      if(this.auth.user.role.name!='seller'){
        this.router.navigate(['/subscribe/'+this.product.id]);
      }else {
        this.isSeller = true;
      }
    }else {
      this.notAuth = true;
    }
  }
}
