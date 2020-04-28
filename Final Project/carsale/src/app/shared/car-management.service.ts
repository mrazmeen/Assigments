import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CarsaleCheckTokenService} from './carsale-check-token.service';
import {UrlConfiguration} from '../components/config/url-configuration';

@Injectable({
  providedIn: 'root'
})
export class CarManagementService {

  constructor(private httpClient: HttpClient, private tokenService: CarsaleCheckTokenService ) { }

  public saveCar(carModel) {
    return this.httpClient.post<any>(UrlConfiguration.URL_ADD_CAR, carModel);
  }
  public getCars() {
    return this.httpClient.get<any>(UrlConfiguration.VIEW_CARS /*, {
      headers: this.cardoorTokenService.createAuthorizationHeader()
    }*/);
  }
}
