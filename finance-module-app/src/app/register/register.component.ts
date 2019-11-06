import { Component, OnInit } from '@angular/core';
import { finance } from '../model/finance';
import { FinanceuserService } from '../financeuser/financeuser.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  finance: finance = new finance();
  fin : finance = new finance();
  public barLabel: string = "Password strength:";
  public myColors = ['#DD2C00', '#FF6D00', '#FFD600', '#AEEA00', '#00C853'];
  submitted = false;
  //login : LoginComponent;
  constructor(private financeService: FinanceuserService, private router: Router) {
    
   }
  ngOnInit() {
  }

  newFinanceUser(): void {
    this.submitted = false;
    this.finance = new finance();
  }

  registerFinanceUser() {
    this.financeService.createFinanceUser(this.finance)
      .subscribe(data => this.fin, error => console.log(error));
    //this.employee = new Employee();
    //this.toastr.success('Employee Added Successfully!', 'Congratulations!');
            //this.router.navigate(['/login']);
            //this.login.ngOnInit();
        if(this.fin!=null){
            alert("Employee successfully registered!");
            this.router.navigate(['login']);
        }else{
          alert("Employee could not be registered!");
          this.router.navigate(['register']);
        }
  }

  onSubmit() {
    this.submitted = true;
    this.registerFinanceUser();
  }
}
