import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {AboutComponent} from './components/about/about.component';
import {BlogComponent} from './components/blog/blog.component';
import {CarDetailsComponent} from './components/car-details/car-details.component';
import {CarListingComponent} from './components/car-listing/car-listing.component';
import {CarServiceComponent} from './components/car-service/car-service.component';
import {ContactComponent} from './components/contact/contact.component';
import {ErrorPageComponent} from './components/error-page/error-page.component';
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {DashboardComponent} from './components/admin/dashboard/dashboard.component';
import {CarManagementComponent} from './components/admin/car-management/car-management.component';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {LogoutComponent} from './components/logout/logout.component';

const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'blog', component: BlogComponent},
  { path: 'about', component: AboutComponent},
  { path: 'details', component: CarDetailsComponent},
  { path: 'cars', component: CarListingComponent},
  { path: 'service', component: CarServiceComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'admin', component: DashboardComponent},
  { path: 'admin/car-manage', component: CarManagementComponent},
  { path: 'logout', component: LogoutComponent},
  { path: '**', component: NotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
