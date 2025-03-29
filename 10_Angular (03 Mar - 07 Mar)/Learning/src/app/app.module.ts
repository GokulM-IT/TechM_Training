import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { ProjectsComponent } from './pages/projects/projects.component';
import { AboutComponent } from './pages/about/about.component';
import { ContactsComponent } from './pages/contacts/contacts.component';
import { MenuBarComponent } from './common/menu-bar/menu-bar.component';
import { ContactItemComponent } from './pages/contacts/contact-item/contact-item.component';
import { HttpClientModule } from '@angular/common/http';
import { ServiceCardComponent } from './pages/home/service-card/service-card.component';
import { EnquiryFormComponent } from './pages/home/enquiry-form/enquiry-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './common/login/login.component';
import { ProjectCardComponent } from './pages/projects/project-card/project-card.component';
import { EnquiriesComponent } from './pages/enquiries/enquiries.component';
import { FilterServicePipe } from './pipes/filter-service.pipe';
import { HighlightPipe } from './pipes/highlight.pipe';
import { StatusFilterPipe } from './pipes/status-filter.pipe';
import { TeamSizeFilterPipe } from './pipes/team-size-filter.pipe';
import { ServiceDetailsComponent } from './pages/home/service-details/service-details.component';
import { EnquiryResponseComponent } from './pages/enquiries/enquiry-response/enquiry-response.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProjectsComponent,
    AboutComponent,
    ContactsComponent,
    MenuBarComponent,
    ContactItemComponent,
    ServiceCardComponent,
    EnquiryFormComponent,
    LoginComponent,
    ProjectCardComponent,
    EnquiriesComponent,
    EnquiriesComponent,
    FilterServicePipe,
    HighlightPipe,
    TeamSizeFilterPipe,
    StatusFilterPipe,
    ServiceDetailsComponent,
    EnquiryResponseComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
