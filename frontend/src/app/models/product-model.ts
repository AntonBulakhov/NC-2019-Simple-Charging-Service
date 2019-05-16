import {UserModel} from "./user-model";
import {CategoryModel} from "./category-model";
import {UsersafeModel} from "./usersafe-model";

export class ProductModel {
  id: string;
  description: string;
  name: string;
  logoUrl: string;
  price: string;
  user: UsersafeModel;
  category: CategoryModel;

  static cloneBase(product: ProductModel):ProductModel{
    const cloneProductModel: ProductModel = new ProductModel();
    cloneProductModel.id = product.id;
    cloneProductModel.description = product.description;
    cloneProductModel.name = product.name;
    cloneProductModel.logoUrl = product.logoUrl;
    cloneProductModel.price = product.price;
    cloneProductModel.user = product.user;
    cloneProductModel.category = product.category;
    return cloneProductModel;
  }
}
