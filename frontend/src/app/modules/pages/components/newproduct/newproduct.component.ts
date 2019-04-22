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
  public category: string;
  public ready: boolean;
  public productExists: boolean = false;

  constructor(private productService: ProductService,
              private userService: UserService,
              private categoryService: CategoryService) { }

  ngOnInit() {
    this.categoryService.getAllCategories().subscribe(cats=>{
      this.categories = cats as CategoryModel[];
      this.ready = true;
      this.category = this.categories[0].name;
    });
    this.userService.getUSerById("2").subscribe((user)=>{
      this.seller = user as UserModel;
    });
  }

  public saveImage(files){
    this.productImage = files[0];
  }

  public createNewProduct(): void{
    this.newProduct.logoUrl = this.newProduct.name+"-logo.jpg";
    this.newProduct.user = this.seller;
    this.newProduct.category = this.getCategory(this.category);
    console.log(this.newProduct);
  }

  public ifExistsByName(name: string): void{
    if(name != undefined) {
      this.productService.findProductByName(name).subscribe(value=>{
        this.productExists = value;
      })
    }
  }

  public getCategory(name:string): CategoryModel{
    return this.categories.find(obj=> obj.name == name);
  }

}
