import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogoCarroComponent } from './components/catalogo-carro/catalogo-carro.component';

import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { SellCar02Component } from './components/sellCar/sell-car02/sell-car02.component';
import { SellCar07Component } from './components/sellCar/sell-car07/sell-car07.component';
import { SellPart02Component } from './components/sellPart/sell-part02/sell-part02.component';
import { SellPart06Component } from './components/sellPart/sell-part06/sell-part06.component';
import { AnnounceComponent } from './components/announce/announce.component';
import { AnnouncePartComponent } from './components/announce-part/announce-part.component';
import { PartsCatalogComponent } from './components/parts-catalog/parts-catalog.component';
import { AuthService } from './Services/auth.service';
import { PasswordRecoveryComponent } from './components/password-recovery/password-recovery.component';
import { EditarAnuncioComponent } from './components/editar-anuncio/editar-anuncio.component';
import { EditPasswordComponent } from './components/edit-password/edit-password.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'cars-catalog', component: CatalogoCarroComponent},
  {path: 'parts-catalog', component: PartsCatalogComponent},
  {path: 'login', component: LoginComponent},
  {path: 'cadastro', component: RegisterComponent},
  {path: 'sell-car02', component: SellCar02Component , canActivate:[AuthService]},
  {path: 'sell-car07', component: SellCar07Component, canActivate:[AuthService]},
  {path: 'editar-anuncio/:id', component: EditarAnuncioComponent, canActivate:[AuthService]},
  {path: 'sell-part02', component: SellPart02Component, canActivate:[AuthService]},
  {path: 'sell-part06', component: SellPart06Component, canActivate:[AuthService]},
  {path: 'profile', component: ProfileComponent, canActivate:[AuthService]},
  {path: 'anuncio/:id', component : AnnounceComponent},
  {path: 'anuncio-part/:id', component : AnnouncePartComponent},
  {path: 'password-recovery', component: PasswordRecoveryComponent},
  {path: 'mudar-senha/:id', component: EditPasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,
    {scrollPositionRestoration: 'enabled'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
