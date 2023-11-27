import { Component, OnInit } from '@angular/core';
import { UserLogin } from 'src/app/model/user-login';
import { LoginService } from 'src/app/services/user/login/login.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginError, LoginResponse } from './login-interface/login-interface';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent implements OnInit {
  user: UserLogin = new UserLogin('', '');
  message = '';
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private loginService: LoginService
  ) {}

  ngOnInit(): void {}

  doLogin() {
    this.loginSubmit(this.user);
  }

  loginSubmit(user: UserLogin) {
    this.loginService.loginUser(user).subscribe(
      (res: any) => {
        if (res && res.message === 'Login Successful') {
          this.router.navigate(['/home']);
        } else {
          console.error('Unexpected response format: ' + res);
        }
      },
      (error) => {
        console.error('Error: ', error);
        if (error instanceof HttpErrorResponse) {
          console.error('Status: ', error.status);
          console.error('Response body: ', error.error);
        }
      }
    );
  }
}
