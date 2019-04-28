import {UserModel} from "./user-model";

export class BillingAccountModel {
  id: string;
  sum: number;
  name: string;
  user: UserModel;

  static cloneBase(wallet: BillingAccountModel): BillingAccountModel{
    const cloneWallet: BillingAccountModel = new BillingAccountModel();
    cloneWallet.id = wallet.id;
    cloneWallet.sum = wallet.sum;
    cloneWallet.name = wallet.name;
    cloneWallet.user = wallet.user;
    return cloneWallet;
  }
}
