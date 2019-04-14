import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {RoleModel} from "../models/role-model";

@Injectable()
export class RoleService {
  constructor(private http:HttpClient){
  }

  getAllRoles():Observable<RoleModel[]>{
    return this.http.get<RoleModel[]>("/api/role/get_all");
  }
}
