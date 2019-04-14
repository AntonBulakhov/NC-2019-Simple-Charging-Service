export class CategoryModel {
  id: string;
  name: string;

  static cloneBase(category: CategoryModel): CategoryModel{
    const cloneCategoryModel: CategoryModel = new CategoryModel();
    cloneCategoryModel.id = category.id;
    cloneCategoryModel.name = category.name;
    return cloneCategoryModel;
  }
}
