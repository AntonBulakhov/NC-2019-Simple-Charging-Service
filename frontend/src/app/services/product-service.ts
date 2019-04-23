import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductModel} from "../models/product-model";

@Injectable()
export class ProductService {

  constructor(private http:HttpClient){

  }

  getAllProducts():Observable<ProductModel[]>{
    return this.http.get<ProductModel[]>("/api/products/");
  }

  getTopFourProducts():Observable<ProductModel[]>{
    return this.http.get<ProductModel[]>("/api/products/top4");
  }

  getProductById(id: string): Observable<ProductModel>{
    return this.http.get<ProductModel>("/api/products/id/"+id);
  }

  getProductByName(name: string): Observable<ProductModel>{
    return this.http.get<ProductModel>("/api/products/name/"+name);
  }

  findProductByName(name: string): any{
    return this.http.post("/api/products/name", name);
  }

  saveNewProduct(product: ProductModel): Observable<ProductModel>{
    return this.http.post<ProductModel>("/api/products", product);
  }
}
