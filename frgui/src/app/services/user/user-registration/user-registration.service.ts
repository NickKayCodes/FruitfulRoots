import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInfo } from 'src/app/model/user-info';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public registerUser(newUser: UserInfo):Observable<any>{
    return this.http.post<any>(`${this.apiServerUrl}/user/register`, newUser)
  }

}
