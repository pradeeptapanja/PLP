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
  }

  changePassword(){
    this.userId = sessionStorage.getItem('userId');
    this.service.updateFinanceUserPassword(this.userId, this.oldPassword, this.newPassword).subscribe(data => this.finance, error => alert("Password could not be changed!"));
    if(this.finance != null){
      alert("Password changed successfully!");
      this.router.navigate(['search']);
    }else{
      alert("Password could not be changed!");
    }
  }
}
