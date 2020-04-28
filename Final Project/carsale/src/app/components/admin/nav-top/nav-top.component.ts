import { Component, OnInit } from '@angular/core';
import {ApiService} from '../../../shared/api.service';
import {Approuter} from '../../config/approuter';

@Component({
  selector: 'app-nav-top',
  templateUrl: './nav-top.component.html',
  styleUrls: ['./nav-top.component.css']
})
export class NavTopComponent implements OnInit {

  constructor(public apiService: ApiService) { }

  ngOnInit(): void {
  }
  public goToHome() {
    Approuter.reloadHome();
  }
}
