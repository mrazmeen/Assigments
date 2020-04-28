import { Component, OnInit } from '@angular/core';
import {Approuter} from '../../config/approuter';

@Component({
  selector: 'app-leftside-panal',
  templateUrl: './leftside-panal.component.html',
  styleUrls: ['./leftside-panal.component.css']
})
export class LeftsidePanalComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  public reloadCarManagement() {
    Approuter.reloadAdminCars();
  }
  public reloadDashboard() {
    Approuter.reloadAdmin();
  }
}
