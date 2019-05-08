import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {UserModel, AuthToken} from "../models/user-model";
import {Observable} from "rxjs";
import {NavigationExtras, Router} from "@angular/router";
import {UsersafeModel} from "../models/usersafe-model";

@Injectable()
export class AuthService {
  public user: UsersafeModel;
  public token: string;

  public authError: boolean = false;

  constructor(private http: HttpClient,
              private router: Router){
    let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if(user && token){
      this.user = user;
      this.token = token;
    }else {
      this.user = null;
      this.token = "";
    }
  }

  public getToken(user: UserModel):Observable<AuthToken>{
    return this.http.post<AuthToken>("/api/users/auth/token", user);
  }

  // public regNewUser(user: UserModel): Observable<AuthToken>{
  //   return this.http.post<AuthToken>('api/users/auth/sign-up',user);
  // }

  public regNewUser(user: UserModel): Observable<UserModel>{
    return this.http.post<UserModel>('api/users/auth/sign-up',user);
  }

  public userAuth():Observable<UserModel>{
    return this.http.get<UserModel>("/api/users/auth/user");
  }

  public signIn(authUser: UserModel):void{
    this.getToken(authUser).subscribe(data=>{
      this.token = data.token;
      this.userAuth().subscribe(data=>{
        this.user = data;
        localStorage.setItem("user", JSON.stringify(this.user));
        localStorage.setItem("token", this.token);
        this.router.navigate(['']);
       setTimeout(location.reload.bind(location), 100);
      }, error1 => {
        this.toErrorPage(error1);
      })
    }, error1 => {
      this.authError = true;
    })
  }

  // public signUp(authUser: UserModel):void{
  //   this.regNewUser(authUser).subscribe(data=>{
  //     this.token = data.token;
  //     this.userAuth().subscribe(data=>{
  //       localStorage.setItem("user", JSON.stringify(data));
  //       localStorage.setItem("token", this.token);
  //       this.user = data;
  //       this.router.navigate(['']);
  //     }, error1 => {
  //       this.toErrorPage(error1);
  //     })
  //   }, error1 => {
  //     this.toErrorPage(error1);
  //   })
  // }

  public signUp(authUser: UserModel):void{
    this.regNewUser(authUser).subscribe(data=>{
      this.router.navigate(['']);
    }, error1 => {
      this.toErrorPage(error1);
    })
  }

  public logOut():void{
    localStorage.clear();
    this.user = null;
    this.token = "";
    this.router.navigate(['']);
    setTimeout(location.reload.bind(location), 100);
  }

  public toErrorPage(error1){
    let nav: NavigationExtras = {
      queryParams:{
        "code": error1.status,
        "message": error1.statusText
      }
    };
    this.router.navigate(['/error'], nav)
  }
}
