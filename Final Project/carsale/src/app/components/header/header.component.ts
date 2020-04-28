import {Component, OnInit} from '@angular/core';
import {Approuter} from '../config/approuter';
import {ApiService} from '../../shared/api.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public loginService: ApiService) {
  }

  ngOnInit(): void {
  }

  public reloadLoginPage() {
    Approuter.reloadLogin();
  }

  public reloadRegisterPage() {
    Approuter.reloadRegister();
  }

  public reloadHomePage() {
    Approuter.reloadHome();
  }

  public reloadAdminPage() {
    Approuter.reloadAdmin()
  }
}
