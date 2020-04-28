import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {ApiService} from './api.service';
import {Approuter} from '../components/config/approuter';

@Injectable({
  providedIn: 'root'
})
export class CarsaleAuthGuardService implements CanActivate {

  constructor(private router: Router, private carsalelogin: ApiService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.carsalelogin.isUserLoggedIn()) {
      return true;
    } else {
      Approuter.reloadLogin();
      return false;
    }
  }
}
