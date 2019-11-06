import { Component, OnInit } from '@angular/core';
import { FinanceuserService } from '../financeuser/financeuser.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  userId : string;
  oldPassword : string;
  newPassword : string;
  finance : string
  constructor(private service : FinanceuserService, private router : Router) { }

  ngOnInit() {
    if(sessionStorage.getItem('status')==='false'){
      this.router.navigate(['login']);
    }
    this.userId = sessionStorage.getItem('financeUserId');
  }

  changePassword(){

    let fin = this.service.updateFinanceUserPassword(this.userId, this.oldPassword, this.newPassword).subscribe(data => this.finance, error => alert("Password could not be changed!"));
    if(fin != null){
      alert("Password changed successfully!");
      this.router.navigate(['claim']);
    }else{
      alert("Password could not be changed!");
    }
  }
}
