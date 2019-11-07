import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { finance } from '../model/finance';
import { ClaimModel } from '../model/claim';

@Injectable({
  providedIn: 'root'
})
export class FinanceuserService {

  fin: finance;
  claims: ClaimModel[] = [];
  index: number;

  private baseUrl = 'http://localhost:7100/finance-team';
  constructor(private http: HttpClient) {
  }

  saveFinanceUser(finance: finance) {
    console.log("saving finance user");
    this.fin = finance;
    console.log(finance);
    console.log(sessionStorage);
  }

  deleteEmployee() {
    console.log("Logged out successfully!")
    this.fin = null;
    alert("Logged out!");
  }

  createFinanceUser(finance: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + '/register', finance);
  }

  loginFinanceUser(userId: string, password: string): Observable<any> {
    return this.http.get(this.baseUrl + "/login/" + userId + "/" + password);
  }


  updateFinanceUserPassword(oldPassword: string, newPassword: string): Observable<any> {

    if ((sessionStorage.getItem('financeUserPassword')) == oldPassword)
      return this.http.get(this.baseUrl + "/update-password/?userId=" + sessionStorage.getItem('financeUserId') + "&oldPassword=" + oldPassword + "&newPassword=" + newPassword);
    else {
      alert("Password could not be changed!");
      return null;
    }
  }

  listClaims() {
    return this.http.get<ClaimModel[]>(this.baseUrl + "/getclaims");
  }

  approveClaims(claimId: number) {
    return this.http.put<number>("http://localhost:7100/finance-team/claimapprove/" + claimId, null);
  }

  rejectClaims(claimId: number) {
    return this.http.put<number>("http://localhost:7100/finance-team/claimreject/" + claimId, null);
  }
}
