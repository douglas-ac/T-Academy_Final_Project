import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { NgxMaskModule } from 'ngx-mask';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CatalogoCarroComponent } from './components/catalogo-carro/catalogo-carro.component';
import { LoginComponent } from './components/login/login.component';
import { MatButtonModule } from '@angular/material/button';
import { RegisterComponent } from './components/register/register.component';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SellCar01Component } from './components/sellCar/sell-car01/sell-car01.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { MatGridListModule } from '@angular/material/grid-list';
import { SellCar02Component } from './components/sellCar/sell-car02/sell-car02.component'
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { SellCar07Component } from './components/sellCar/sell-car07/sell-car07.component';
import { SellPart01Component } from './components/sellPart/sell-part01/sell-part01.component';
import { SellPart02Component } from './components/sellPart/sell-part02/sell-part02.component';
import { SellPart03Component } from './components/sellPart/sell-part03/sell-part03.component';
import { SellPart04Component } from './components/sellPart/sell-part04/sell-part04.component';
import { SellPart05Component } from './components/sellPart/sell-part05/sell-part05.component';
import { SellPart06Component } from './components/sellPart/sell-part06/sell-part06.component';
import { ProfileComponent } from './components/profile/profile.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CartComponent } from './components/cart/cart.component';
import { MatDividerModule } from '@angular/material/divider';
import { AnnounceComponent } from './components/announce/announce.component';
import { LOCALE_ID } from '@angular/core';
import { PartsCatalogComponent } from './components/parts-catalog/parts-catalog.component';

@NgModule({
  declarations: [
    AppComponent,
    CatalogoCarroComponent,
    LoginComponent,
    RegisterComponent,
    SellCar01Component,
    SellCar02Component,
    SellCar07Component,
    SellPart01Component,
    SellPart02Component,
    SellPart03Component,
    SellPart04Component,
    SellPart05Component,
    SellPart06Component,
    ProfileComponent,
    NavbarComponent,
    CartComponent,
    PartsCatalogComponent,
    AnnounceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatToolbarModule,
    MatGridListModule,
    MatSelectModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatDividerModule,
    NgxMaskModule.forRoot()
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'en-US'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
