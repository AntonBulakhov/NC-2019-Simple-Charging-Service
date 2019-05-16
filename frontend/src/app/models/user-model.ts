import {RoleModel} from "./role-model";

export class UserModel {
  id: string;
  email: string;
  login: string;
  password: string;
  logoUrl: string;
  blocked: number;
  firstname: string;
  secondname: string;
  role: RoleModel;

  static cloneBase(user: UserModel):UserModel{
    const cloneUserModel: UserModel = new UserModel();
    cloneUserModel.id = user.id;
    cloneUserModel.email = user.email;
    cloneUserModel.login = user.login;
    cloneUserModel.password = user.password;
    cloneUserModel.logoUrl = user.logoUrl;
    cloneUserModel.blocked = user.blocked;
    cloneUserModel.firstname = user.firstname;
    cloneUserModel.secondname = user.secondname;
    cloneUserModel.role = user.role;
    return cloneUserModel;
  }
}

export class AuthToken{
  token:string;
}
