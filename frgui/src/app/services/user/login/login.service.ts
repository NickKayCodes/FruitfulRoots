import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogin } from 'src/app/model/user-login';
import { Observable, map } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LoginResponse } from 'src/app/components/login/login-interface/login-interface';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public loginUser(user: UserLogin): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(
      `${this.apiServerUrl}/user/login`,
      user
    );
  }
}
