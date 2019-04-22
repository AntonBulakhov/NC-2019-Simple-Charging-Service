import { Component, OnInit } from '@angular/core';
import {ProductModel} from "../../../../models/product-model";
import {UserModel} from "../../../../models/user-model";
import {ProductService} from "../../../../services/product-service";
import {UserService} from "../../../../services/user-service";
import {CategoryModel} from "../../../../models/category-model";
import {CategoryService} from "../../../../services/category-service";

@Component({
  selector: 'charging-addnewproduct',
  templateUrl: './newproduct.component.html',
  styleUrls: ['./newproduct.component.css']
})
export class NewproductComponent implements OnInit {

  public newProduct: ProductModel = new ProductModel();
  public seller: UserModel;
  public categories: CategoryModel[];
  public productImage: File = null;
  public ready: boolean;
  public productExists: boolean = false;

  constructor(private productService: ProductService,
              private userService: UserService,
              private categoryService: CategoryService) { }

  ngOnInit() {
    this.categoryService.getAllCategories().subscribe(cats=>{
      this.categories = cats as CategoryModel[];
      this.ready = true;
    });
    this.userService.getUSerById("2").subscribe((user)=>{
      this.seller = user as UserModel;
    });
  }

  public saveImage(files){
    this.productImage = files[0];
  }

  public createNewProduct(): void{
    const myNewFile = new File([this.productImage], this.newProduct.name+"-logo.jpg".trim(), {type: this.productImage.type});
    this.newProduct.logoUrl = myNewFile.name;
    this.newProduct.user = this.seller;
    console.log(this.newProduct);

  }

  public ifExistsByName(name: string): void{
    if(name != undefined) {
      this.productService.findProductByName(name).subscribe(value=>{
        this.productExists = value;
      })
    }
  }

}
