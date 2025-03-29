import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { CurrencyPipe } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { CampsComponent } from './pages/home/camps/camps.component';
import { HomeComponent } from './pages/home/home.component';
import { NewCampComponent } from './pages/new-camp/new-camp.component';
import { CustomCurrencyPipe } from './pipes/custom-currency.pipe';
import { StarPipe } from './pipes/star.pipe';
import { NavBarComponent } from './common/nav-bar/nav-bar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './common/login/login.component';
import { FooterComponent } from './common/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CampsComponent,
    NewCampComponent,
    NavBarComponent,
    LoginComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CustomCurrencyPipe,
    StarPipe,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [CurrencyPipe],
  bootstrap: [AppComponent],
})
export class AppModule {}
