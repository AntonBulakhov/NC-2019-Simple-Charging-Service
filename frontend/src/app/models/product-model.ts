import {UserSafeModel} from "./user-model";
import {CategoryModel} from "./category-model";

export class ProductModel {
  id: string;
  description: string;
  name: string;
  logoUrl: string;
  videoLink: string;
  price: string;
  user: UserSafeModel;
  category: CategoryModel;

  static cloneBase(product: ProductModel):ProductModel{
    const cloneProductModel: ProductModel = new ProductModel();
    cloneProductModel.id = product.id;
    cloneProductModel.description = product.description;
    cloneProductModel.name = product.name;
    cloneProductModel.logoUrl = product.logoUrl;
    cloneProductModel.videoLink = product.videoLink;
    cloneProductModel.price = product.price;
    cloneProductModel.user = product.user;
    cloneProductModel.category = product.category;
    return cloneProductModel;
  }
}
