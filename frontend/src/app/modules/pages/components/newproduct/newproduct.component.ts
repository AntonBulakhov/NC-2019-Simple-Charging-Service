import { Component, OnInit } from '@angular/core';
import {ProductModel} from "../../../../models/product-model";
import {UserModel} from "../../../../models/user-model";
import {ProductService} from "../../../../services/product-service";
import {UserService} from "../../../../services/user-service";
import {CategoryModel} from "../../../../models/category-model";
import {CategoryService} from "../../../../services/category-service";
import {Router} from "@angular/router";
import {AuthService} from "../../../../services/auth-service";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'charging-addnewproduct',
  templateUrl: './newproduct.component.html',
  styleUrls: ['./newproduct.component.css']
})
export class NewproductComponent implements OnInit {

  public newProduct: ProductModel = new ProductModel();
  public seller: UserModel;
  public categories: CategoryModel[];
  public category: string;
  public ready: boolean;
  public productExists: boolean = false;
  public productImage: File = null;

  constructor(private productService: ProductService,
              private userService: UserService,
              private categoryService: CategoryService,
              private router: Router,
              public auth: AuthService,
              private titleService: Title) {
    titleService.setTitle("New product")
  }

  ngOnInit() {
    if(this.auth.user == null || this.auth.user.role.name != "seller"){
      this.router.navigate(['']);
    }else{
      this.categoryService.getAllCategories().subscribe(cats=>{
        this.categories = cats as CategoryModel[];
        this.ready = true;
        this.category = this.categories[0].name;
      });
      this.userService.getUSerById(this.auth.user.id).subscribe((user)=>{
        this.seller = user as UserModel;
      });
    }
  }

  public onChange(files): void{
    this.productImage = files[0];
  }

  public createNewProduct(): void{
    this.newProduct.user = this.seller;
    this.newProduct.category = this.getCategory(this.category);
    this.newProduct.logoUrl = this.newProduct.name+"-logo.jpg".trim();

    this.productService.saveProductImage(this.productImage, this.newProduct.logoUrl.trim()).subscribe(()=>{
      this.productService.saveNewProduct(this.newProduct).subscribe((resp)=>{
        let product:ProductModel = resp as ProductModel;
        this.router.navigate(['/product/'+product.id]);
      }, ()=>{
        this.router.navigate(['/404']);
      });
    });
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
