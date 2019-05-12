import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SubscriptionModel} from "../models/subscription-model";

@Injectable()
export class SubscriptionService {
  constructor(private http: HttpClient){

  }

  getSubsByUser(id: string):Observable<SubscriptionModel[]>{
    return this.http.get<SubscriptionModel[]>("/api/subscriptions/user/"+id);
  }

  createSubscription(sub: SubscriptionModel):Observable<boolean>{
    return this.http.post<boolean>("/api/subscriptions", sub);
  }

  checkSubscriptionExists(userID: string, productID: string):any{
    return this.http.get("/api/subscriptions/exist/"+userID+"/"+productID);
  }

  deleteSubscription(id: string): any{
    return this.http.delete("/api/subscriptions/del/"+id);
  }

  buyMoreSub(sub: SubscriptionModel): Observable<SubscriptionModel>{
    return this.http.put<SubscriptionModel>("/api/subscriptions", sub);
  }
}
