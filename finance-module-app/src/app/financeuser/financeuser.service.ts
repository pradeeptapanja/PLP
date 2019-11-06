import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { finance } from '../model/finance';
import { ClaimModel } from '../model/claim';

@Injectable({
  providedIn: 'root'
})
export class FinanceuserService {

  fin : finance;
  claims : ClaimModel[] = [];
  index : number;

  private baseUrl = 'http://localhost:7100/finance-team';
  constructor(private http: HttpClient) {
   }
  
   saveFinanceUser(finance : finance){
    console.log("saving finance user");
    this.fin = finance;
    console.log(finance);
  }

  deleteEmployee() {
    console.log("Logged out successfully!")
    this.fin = null;
    alert("Logged out!");
  }

   createFinanceUser(finance: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`+'/register', finance);
  }
 
  loginFinanceUser(userId : string, password : string):Observable<any>{
    return this.http.get(this.baseUrl+"/login/"+userId+"/"+password);
  }


  updateFinanceUserPassword(userId: string, oldPassword: string, newPassword: string):Observable<any> {
    let form = new FormData();
    form.append("userId",userId);
    form.append("oldPassword",oldPassword);
    form.append("newPassword",newPassword);
    return this.http.get(this.baseUrl+"/update-password/?userId="+sessionStorage.getItem('financeUserId')+"&oldPassword="+oldPassword+"&newPassword="+newPassword);
  }

  listClaims(){
    return this.http.get<ClaimModel[]>(this.baseUrl+"/getclaims");
  }

  approveClaims(claimId:number){
    return this.http.put<number>("http://localhost:"+claimId,null);
  }

  rejectClaims(claimId:number){
    return this.http.put<number>("http://localhost:"+claimId,null);
  }
}
