import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BillingAccountModel} from "../models/billingaccount-model";
import {UserModel} from "../models/user-model";
import {UsersafeModel} from "../models/usersafe-model";

@Injectable()
export class BillingAccountService {
  constructor(private http:HttpClient){
  }

  getWalletsByUserId(id: string):Observable<BillingAccountModel[]>{
    return this.http.get<BillingAccountModel[]>("/api/baccounts/all/user/"+id);
  }

  updateWallet(updatedBA: BillingAccountModel):Observable<BillingAccountModel>{
    return this.http.put<BillingAccountModel>("/api/baccounts", updatedBA);
  }

  createNewWallet(newW: BillingAccountModel):Observable<BillingAccountModel>{
    return this.http.post<BillingAccountModel>("/api/baccounts", newW);
  }

  deleteWallet(wallet: BillingAccountModel):any{
    return this.http.delete("/api/baccounts/"+wallet.id);
  }

  walletCheckByName(name: string, user: UsersafeModel):any{
    return this.http.get("/api/baccounts/user/"+user.id+"/name/"+name);
  }
}
