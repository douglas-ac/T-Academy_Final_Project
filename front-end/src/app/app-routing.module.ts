import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogoCarroComponent } from './components/catalogo-carro/catalogo-carro.component';

import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { SellCar01Component } from './components/sellCar/sell-car01/sell-car01.component';
import { SellCar02Component } from './components/sellCar/sell-car02/sell-car02.component';
import { SellCar03Component } from './components/sellCar/sell-car03/sell-car03.component';
import { SellCar04Component } from './components/sellCar/sell-car04/sell-car04.component';
import { SellCar05Component } from './components/sellCar/sell-car05/sell-car05.component';
import { SellCar06Component } from './components/sellCar/sell-car06/sell-car06.component';
import { SellCar07Component } from './components/sellCar/sell-car07/sell-car07.component';
import { SellPart01Component } from './components/sellPart/sell-part01/sell-part01.component';
import { SellPart02Component } from './components/sellPart/sell-part02/sell-part02.component';
import { SellPart03Component } from './components/sellPart/sell-part03/sell-part03.component';
import { SellPart04Component } from './components/sellPart/sell-part04/sell-part04.component';
import { SellPart05Component } from './components/sellPart/sell-part05/sell-part05.component';
import { SellPart06Component } from './components/sellPart/sell-part06/sell-part06.component';
<<<<<<< HEAD
import { AnnounceComponent } from './components/announce/announce.component';
=======
import { PartsCatalogComponent } from './components/parts-catalog/parts-catalog.component';
>>>>>>> parts-catalog

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'cars-catalog', component: CatalogoCarroComponent},
  {path: 'parts-catalog', component: PartsCatalogComponent},
  {path: 'login', component: LoginComponent},
  {path: 'cadastro', component: RegisterComponent},
  {path: 'sell-car01', component: SellCar01Component},
  {path: 'sell-car02', component: SellCar02Component},
  {path: 'sell-car03', component: SellCar03Component},
  {path: 'sell-car04', component: SellCar04Component},
  {path: 'sell-car05', component: SellCar05Component},
  {path: 'sell-car06', component: SellCar06Component},
  {path: 'sell-car07', component: SellCar07Component},
  {path: 'sell-part01', component: SellPart01Component},
  {path: 'sell-part02', component: SellPart02Component},
  {path: 'sell-part03', component: SellPart03Component},
  {path: 'sell-part04', component: SellPart04Component},
  {path: 'sell-part05', component: SellPart05Component},
  {path: 'sell-part06', component: SellPart06Component},
  {path: 'profile', component: ProfileComponent},
  {path: 'anuncio/:id', component : AnnounceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
