import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserViewModel} from '../components/register/register.component';
import {APIResponse} from '../components/model/apiresponse';
import {UrlConfiguration} from '../components/config/url-configuration';
// import {ApiResponse} from '../components/login/login.component';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  // private BASE_URL = 'http://localhost:8797/user';
  // private CREATE_USER_URL = `${this.BASE_URL}\\save`;
  // private USER_LOGIN = `${this.BASE_URL}\\login\\`;
  constructor(private http: HttpClient) { }

  createUser(create: UserViewModel) {
    return this.http.post<APIResponse>(UrlConfiguration.CREATE_USER_URL  , create);
  }

   public authenticate( username, password ) {
    return this.http.get<APIResponse>(UrlConfiguration.USER_LOGIN + username + '/' + password);

  }

  public isUserLoggedIn() {
    const user = localStorage.getItem('username'); // sessionStorage.getItem('username');
    return !(user === null);
  }

  public isUserAnAdmin() {
    const userRole = localStorage.getItem('userRole'); // sessionStorage.getItem('userRole');
    return (userRole === 'A');
  }

  public setUserData(username, parameter, accessToken, refreshToken) {

    localStorage.setItem('username', username);
    localStorage.setItem('userRole', parameter);
    localStorage.setItem('accessToken', accessToken);
    localStorage.setItem('refreshToken', refreshToken);
  }

  public logout() {

    localStorage.removeItem('username');
    localStorage.removeItem('userRole');
    localStorage.removeItem('accessToken');
    localStorage.removeItem('refreshToken');
    localStorage.clear();
  }

}
