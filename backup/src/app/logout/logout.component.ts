import { Component, OnInit } from '@angular/core';
import { FinanceuserService } from '../financeuser/financeuser.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private financeService : FinanceuserService, private router : Router) { }

  ngOnInit() {
    this.financeService.deleteEmployee();
    this.router.navigate(['login']);
  }

}
