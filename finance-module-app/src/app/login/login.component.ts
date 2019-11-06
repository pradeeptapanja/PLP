import { Component, OnInit } from '@angular/core';
import { FinanceuserService } from '../financeuser/financeuser.service';
import { Router } from '@angular/router';
import { finance } from '../model/finance';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  financeUserId : string;
  financeUserPassword : string;
  finance: finance;
  appComponent : AppComponent;
  constructor(private service : FinanceuserService, private router : Router) { }

  ngOnInit() {
    this.finance = new finance();
  }

  loginFinanceUser(){
    this.service.loginFinanceUser(this.financeUserId, this.financeUserPassword).subscribe(data => {
      this.finance = data;
      sessionStorage.setItem('financeUserId', String(this.finance.financeUserId));
      sessionStorage.setItem('financeUserPassword',String(this.finance.financeUserPassword));
      sessionStorage.setItem('status','true');
      this.service.saveFinanceUser(this.finance);
      if(this.finance.financeUserId == null)
        this.router.navigate(['login']);
      else{
      this.router.navigate(['claim']);
      alert("Login Successful");
      }
      error => alert("Employee not logged in!");
    });
  }



  

}
