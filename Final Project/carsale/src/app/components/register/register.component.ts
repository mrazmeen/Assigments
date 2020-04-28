import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {ApiService} from '../../shared/api.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  model: UserViewModel = {
    firtstName: '',
    lastName: '',
    username: '',
    password: '',
    email: '',
    contactNo: ''
  };

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
  }

  reloadLogin() {
    window.location.href = 'http://' + window.location.hostname + ':' + window.location.port + '/login';
  }

  saveUser(): void {
    this.apiService.createUser(this.model).subscribe(
      res => {
        alert('User Saved Successfully');
      },
      err => {
        alert('An error has occurred');
      }
    );
  }

}

export interface UserViewModel {
  firtstName: string;
  lastName: string;
  username: string;
  password: string;
  email: string;
  contactNo: string;

}

