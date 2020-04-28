import {Component, OnInit} from '@angular/core';
import {ApiService} from '../../shared/api.service';
import {Router} from '@angular/router';
import {isUndefined} from 'util';
import {APIResponse} from '../model/apiresponse';
import {Approuter} from '../config/approuter';
import swal from 'sweetalert2';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username;
  password;
  invalidLogin = false;
  apiresponse: APIResponse;


  constructor(private router: Router, private apiService: ApiService) {
  }

  ngOnInit(): void {
  }

  goToHome() {
    window.location.href = 'http://' + window.location.hostname + ':' + window.location.port;
  }

  public loginUser(): void {
    console.log('Token: ' + localStorage.getItem('accessToken'));
    // if (this.username !== null && !isUndefined(this.username) && this.password !== null && !isUndefined(this.password)) {
    this.apiService.authenticate(this.username, this.password)
      .subscribe(data => {
        console.log('Login: ' + JSON.stringify(data));

        this.apiresponse = data;

        if (this.apiresponse.message === 'Username or Password is Wrong!') {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!',
            footer: '<a href>Why do I have this issue?</a>'
          });
        } else if (this.apiresponse.message === 'Successful!') {
          this.apiService.setUserData(
            this.username,
            this.apiresponse.parameter,
            this.apiresponse.accessTokens.access_token,
            this.apiresponse.accessTokens.refresh_token);

          this.invalidLogin = false;
          /* this.router.navigate(['']); */

          if (this.apiresponse.parameter === 'U') {
            Approuter.reloadHome();
          } else if (this.apiresponse.parameter === 'A') {
            Approuter.reloadAdmin();
          }
        }
      }, error => {
        console.log(error);
        this.invalidLogin = true;

        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Username or Password is Wrong!'
        });
      });
    // } else {
    //   Swal.fire({
    //     icon: 'error',
    //     title: 'Oops...',
    //     text: 'Fill all details!'
    //   });
    // }
  }
}



