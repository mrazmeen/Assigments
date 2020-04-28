import {Component, OnInit} from '@angular/core';
import {APIResponse} from '../model/apiresponse';
import {ActivatedRoute} from '@angular/router';
import {CarManagementService} from '../../shared/car-management.service';
import {CarsaleCheckTokenService} from '../../shared/carsale-check-token.service';

@Component({
  selector: 'app-car-listing',
  templateUrl: './car-listing.component.html',
  styleUrls: ['./car-listing.component.css']
})
export class CarListingComponent implements OnInit {


  cars: any [];
  apiResponse: APIResponse;
  tokenStatus: boolean;

  constructor(private activatedRoute: ActivatedRoute,
              private carManagementService: CarManagementService,
              private checkTokenService: CarsaleCheckTokenService) {
  }

  ngOnInit(): void {
    this.getAllCars();
  }

   getAllCars() {
    this.cars = [];
    this.carManagementService.getCars().subscribe(data => {
      console.log('data: ' + JSON.stringify(data));
      this.cars = data;
    }, error => {
      console.log('error: ' + JSON.stringify(error));
    });

  }
}
