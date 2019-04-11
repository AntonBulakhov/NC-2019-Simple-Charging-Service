import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductModel} from "../models/product-model";

@Injectable()
export class ProductService {

  constructor(private http:HttpClient){

  }

  getAllProducts():Observable<ProductModel[]>{
    return this.http.get<ProductModel[]>("/api/product/get_all");
  }

  getTopFourProducts():Observable<ProductModel[]>{
    return this.http.get<ProductModel[]>("/api/product/get_top_4");
  }

  getProductById(id: string): Observable<ProductModel>{
    return this.http.get<ProductModel>("/api/product/get/"+id);
  }
}
