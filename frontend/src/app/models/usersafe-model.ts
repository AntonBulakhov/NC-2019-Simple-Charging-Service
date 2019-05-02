import {RoleModel} from "./role-model";

export class UsersafeModel {
  id: string;
  email: string;
  logoUrl: string;
  firstname: string;
  secondname: string;
  role: RoleModel;

  static cloneBase(user: UsersafeModel): UsersafeModel {
    const cloneUserModel: UsersafeModel = new UsersafeModel();
    cloneUserModel.id = user.id;
    cloneUserModel.email = user.email;
    cloneUserModel.logoUrl = user.logoUrl;
    cloneUserModel.firstname = user.firstname;
    cloneUserModel.secondname = user.secondname;
    cloneUserModel.role = user.role;
    return cloneUserModel;
  }
}
