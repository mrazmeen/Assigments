import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {ApiService} from '../../shared/api.service';
import {Approuter} from '../config/approuter';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router,
              private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.logout();
    this.goToHome();
  }

  public goToHome() {
    Approuter.reloadHome();
  }
}
