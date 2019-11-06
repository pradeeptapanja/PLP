import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { UpdateComponent } from './update/update.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NavigateRoutingModule } from './navigate/navigate-routing.module';
import { HttpErrorInterceptor } from './http-interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PasswordStrengthBarModule } from 'ng2-password-strength-bar';
import { NgxPaginationModule } from 'ngx-pagination';
import { ClaimComponent } from './claim/claim.component';
import { LogoutComponent } from './logout/logout.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    UpdateComponent,
    LoginComponent,
    ClaimComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    NavigateRoutingModule,
    PasswordStrengthBarModule,
    NgxPaginationModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpErrorInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
