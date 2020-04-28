import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { CarServiceComponent } from './components/car-service/car-service.component';
import { AboutComponent } from './components/about/about.component';
import { ErrorPageComponent } from './components/error-page/error-page.component';
import { ContactComponent } from './components/contact/contact.component';
import { BlogComponent } from './components/blog/blog.component';
import { CarListingComponent } from './components/car-listing/car-listing.component';
import { CarDetailsComponent } from './components/car-details/car-details.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { DashboardComponent } from './components/admin/dashboard/dashboard.component';
import { CarManagementComponent } from './components/admin/car-management/car-management.component';
import { LeftsidePanalComponent } from './components/admin/leftside-panal/leftside-panal.component';
import { NavTopComponent } from './components/admin/nav-top/nav-top.component';
import { AdminFooterComponent } from './components/admin/admin-footer/admin-footer.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { LogoutComponent } from './components/logout/logout.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    CarServiceComponent,
    AboutComponent,
    ErrorPageComponent,
    ContactComponent,
    BlogComponent,
    CarListingComponent,
    CarDetailsComponent,
    HeaderComponent,
    FooterComponent,
    DashboardComponent,
    CarManagementComponent,
    LeftsidePanalComponent,
    NavTopComponent,
    AdminFooterComponent,
    NotFoundComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
