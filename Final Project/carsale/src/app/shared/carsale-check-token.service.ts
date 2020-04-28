import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {APIResponse} from '../components/model/apiresponse';

@Injectable({
  providedIn: 'root'
})
export class CarsaleCheckTokenService {

  constructor(private httpClient: HttpClient) {
  }

  public checkToken(username, accessToken, refreshToken) {
    return this.httpClient.get<APIResponse>('http://localhost:8797/user/checktoken/' + username + '/' + accessToken + '/' + refreshToken);
  }
}
