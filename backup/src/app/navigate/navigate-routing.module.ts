import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from '../register/register.component';
import { LoginComponent } from '../login/login.component';
import { UpdateComponent } from '../update/update.component';
import { ClaimComponent } from '../claim/claim.component';
import { LogoutComponent } from '../logout/logout.component';

const routes: Routes = [
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'register',component:RegisterComponent},
  {path:'login',component:LoginComponent},
  {path:'update',component:UpdateComponent},
  {path:'claim',component:ClaimComponent},
  {path:'logout',component:LogoutComponent},
  {path:'**',redirectTo:'/login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NavigateRoutingModule { }
