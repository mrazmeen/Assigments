import {Component, OnInit} from '@angular/core';
import {CarManagementService} from '../../../shared/car-management.service';
import {CarsaleCheckTokenService} from '../../../shared/carsale-check-token.service';
import {ApiService} from '../../../shared/api.service';
import {APIResponse} from '../../model/apiresponse';
import {CarFeature} from '../../model/car-feature';
import {CarPhotos} from '../../model/car-photos';
import {CarModel} from '../../model/car-model';
import {Car} from '../../model/car';
import {Approuter} from '../../config/approuter';
import {NgForm} from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-car-management',
  templateUrl: './car-management.component.html',
  styleUrls: ['./car-management.component.css']
})
export class CarManagementComponent implements OnInit {

  constructor(private carManagementService: CarManagementService,
              private carSaleTokenService: CarsaleCheckTokenService,
              private apiService: ApiService) {
  }

  apiResponse: APIResponse;
  // carFeature: CarFeature = new CarFeature('', '', '', '',
  //   '', '', '', '');
  carPhotos: CarPhotos = new CarPhotos('/fdsfdsf', 'dsadadada');
  carModel: CarModel = new CarModel('', '', '', '', '', '', '', '', '', '', 0, '',
    '', '', '', '', '', '', '', [this.carPhotos]);
  // car: Car = new Car('', this.carModel);
  carBrandNames = [/*'Choose...',*/ 'MERCEDES BENZ', 'BMW', 'AUDI', 'TOYOTA', 'NISSAN', 'MAZDA', 'FERRARI', 'BENTLEY'];
  carTypes = ['Sedan', 'Coupe', 'Hatchback'];
  carConditions = ['New', 'Used', 'Re-Conditioned'];

  carDisplayBrandName: string;
  tokenStatus: boolean;

  ngOnInit(): void {
    this.tokenStatus = false;

    if (!this.apiService.isUserAnAdmin()) {
      Approuter.reloadNotFound();
    }
  }

  public goToLogout() {
    Approuter.reloadLogout();
  }

  async addCar() {
    console.log('Calling Method Check Token: Token Status - ' + this.tokenStatus);
    await this.checkToken();
    console.log('Token Status: ' + this.tokenStatus);

    // const uploadCarData = new FormData();
    // uploadCarData.append('car', JSON.stringify(this.carModel));

    console.log(this.carModel);
    // console.log(uploadCarData.get('car'));
    console.log('token: ' + localStorage.getItem('accessToken'));

    if (this.tokenStatus) {
      this.carManagementService.saveCar(this.carModel)
        .subscribe(data => {
          console.log(data);
          console.log('Data: ' + JSON.stringify(data));

          if (data.message === 'Successful!') {
            Swal.fire({
              icon: 'success',
              title: 'Successful!',
              text: 'Successfully Created!'
            });
            this.clear(data);
            /*this.car = null;
            this.selectedFileOne = null;
            this.selectedFileTwo = null;
            this.selectedFileThree = null;*/

          } else if (data.message === 'Unsuccessful!') {
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'Error while Creating! Please Try Again!'
            });
          } else if (data.message === 'Car Exists!') {
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'Car Already Exists!'
            });
          }
        }, error => {
          console.log(error);
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Error while Creating! Please Try Again!'
          });
        });
    } else {

      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Session Timed Out! Login Back!',
        showCancelButton: true,
      })
        .then(result => {
          if (result) {
            this.goToLogout();
          } else {
            this.goToLogout();
          }
        });
    }
  }

  async checkToken() {
    await this.carSaleTokenService.checkToken(
      localStorage.getItem('username'),
      localStorage.getItem('accessToken'),
      localStorage.getItem('refreshToken'))
      .toPromise()
      .then(data => {
        console.log('data: ' + data.message);

        this.apiResponse = data;

        if (this.apiResponse.message === 'Continue!') {
          console.log(this.apiResponse.message);

          this.tokenStatus = true;
        } else if (this.apiResponse.message === 'New Token!') {
          console.log('O: ' + localStorage.getItem('accessToken'));

          // sessionStorage.setItem('accessToken', this.apiResponse.accessTokens.access_token);
          // sessionStorage.setItem('refreshToken', this.apiResponse.accessTokens.refresh_token);

          localStorage.removeItem('accessToken');
          localStorage.removeItem('refreshToken');

          localStorage.setItem('accessToken', this.apiResponse.accessTokens.access_token);
          localStorage.setItem('refreshToken', this.apiResponse.accessTokens.refresh_token);

          console.log('N :' + localStorage.getItem('accessToken'));

          this.tokenStatus = true;
        } else if (this.apiResponse.message === 'Unsuccessful!') {
          this.tokenStatus = false;
        } else {
          this.tokenStatus = false;
        }
      }, error => {
        console.log('Error: ' + error);

        this.tokenStatus = false;
      });
  }

  clear(form: NgForm) {
    form.resetForm();
  }
}
