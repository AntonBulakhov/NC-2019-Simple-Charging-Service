import {UserModel} from "./user-model";
import {UsersafeModel} from "./usersafe-model";

export class BillingAccountModel {
  id: string;
  sum: number;
  name: string;
  user: UsersafeModel;

  static cloneBase(wallet: BillingAccountModel): BillingAccountModel{
    const cloneWallet: BillingAccountModel = new BillingAccountModel();
    cloneWallet.id = wallet.id;
    cloneWallet.sum = wallet.sum;
    cloneWallet.name = wallet.name;
    cloneWallet.user = wallet.user;
    return cloneWallet;
  }
}
