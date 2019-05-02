import {ProductModel} from "./product-model";
import {BillingAccountModel} from "./billingaccount-model";

export class SubscriptionModel {
  id: string;
  time: number;
  blocked: string;
  discount: number;
  product: ProductModel;
  billingAccount: BillingAccountModel;

  static cloneBase(sub: SubscriptionModel): SubscriptionModel{
    const subClone: SubscriptionModel = new SubscriptionModel();
    subClone.id = sub.id;
    subClone.time = sub.time;
    subClone.blocked = sub.blocked;
    subClone.discount = sub.discount;
    subClone.product = sub.product;
    subClone.billingAccount = sub.billingAccount;
    return subClone;
  }
}
