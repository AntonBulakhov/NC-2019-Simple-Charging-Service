import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {UserModel} from "../models/user-model";
import {Observable} from "rxjs";

@Injectable()
export class UserService {
  constructor(private http:HttpClient){
  }

  getAllUsers(page: number, filter: string){
    return this.http.get("/api/users?page="+page+
      (filter!=undefined?"&filter="+filter:"&filter=null"));
  }

  getAllCompanies(page: number){
    return this.http.get("/api/users/companies?page="+page);
  }

  getUSerById(id: string): Observable<UserModel>{
    return this.http.get<UserModel>("/api/users/id/"+id);
  }

  findUserByEmail(email:string): any{
    return this.http.post("/api/users/email",email);
  }

  findUserByLogin(login:string): any{
    return this.http.post("/api/users/login", login);
  }

  saveUserImage(image: File, name: string): any{
    let formdata = new FormData();
    formdata.append("image", image, name);
    return this.http.post("/api/users/image", formdata);
  }

  saveNewUser(user: UserModel):Observable<UserModel>{
    return this.http.post<UserModel>("/api/users", user);
  }
}
