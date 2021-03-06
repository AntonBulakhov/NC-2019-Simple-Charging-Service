import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductModel} from "../models/product-model";

@Injectable()
export class ProductService {

  constructor(private http:HttpClient){

  }

  deleteProduct(id: string):any{
    return this.http.delete("/api/products/id/"+id);
  }

  getAllProducts(page: number, order: string, filter: string){
    return this.http.get("/api/products?page="+page+
      (order!=undefined?"&order="+order:"&order=null")+(filter!=undefined?"&filter="+filter:"&filter=null"));
  }

  getTopFourProducts():Observable<ProductModel[]>{
    return this.http.get<ProductModel[]>("/api/products/top4");
  }

  getProductById(id: string): Observable<ProductModel>{
    return this.http.get<ProductModel>("/api/products/id/"+id);
  }

  getProductByUser(id: string): Observable<ProductModel[]>{
    return this.http.get<ProductModel[]>("/api/products/user/id/"+id);
  }

  getProductByName(name: string): Observable<ProductModel>{
    return this.http.get<ProductModel>("/api/products/name/"+name);
  }

  findProductByName(name: string): any{
    return this.http.post("/api/products/name", name);
  }

  saveProductImage(image: File, name: string): any{
    let formdata = new FormData();
    formdata.append("image", image, name);
    return this.http.post("/api/products/image", formdata);
  }

  saveNewProduct(product: ProductModel): Observable<ProductModel>{
    return this.http.post<ProductModel>("/api/products", product);
  }
}
