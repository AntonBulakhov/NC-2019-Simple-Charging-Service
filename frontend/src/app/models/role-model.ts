export class RoleModel {
  id: string;
  name: string;

  static cloneBase(role: RoleModel):RoleModel{
    const cloneRoleModel: RoleModel = new RoleModel();
    cloneRoleModel.id = role.id;
    cloneRoleModel.name = role.name;
    return cloneRoleModel;
  }

}
