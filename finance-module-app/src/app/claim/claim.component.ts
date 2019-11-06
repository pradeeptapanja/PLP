import { Component, OnInit } from '@angular/core';
import { ClaimModel } from '../model/claim';
import { FinanceuserService } from '../financeuser/financeuser.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-claim',
  templateUrl: './claim.component.html',
  styleUrls: ['./claim.component.css']
})
export class ClaimComponent implements OnInit {

  claims :Observable<ClaimModel[]>;
  constructor() {
    // this.claims = new ClaimModel[];  private service : FinanceuserService
  }


  ngOnInit() {
   //let list = this.service.listClaims().subscribe(data=>this.claims=data);
  }

//   delete(index: number){
//     var ans = confirm("are you sure you want to delete?")
//     if(ans){
//       this.service.deleteCustomer(index); //delete from service
//     }
//   }

//   sortByName(){
//     this.customers = this.service.sortCustomerbyName();
//   }

}
