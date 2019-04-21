import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CategoryModel} from "../models/category-model";

@Injectable()
export class CategoryService {

  constructor(private http: HttpClient){

  }

  getAllCategories():Observable<CategoryModel[]>{
    return this.http.get<CategoryModel[]>("/api/categories");
  }

}
