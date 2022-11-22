import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogoCarroComponent } from './components/catalogo-carro/catalogo-carro.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {path: 'catalogoCarros', component: CatalogoCarroComponent},
  {path: 'login', component: LoginComponent},
  {path: 'cadastro', component: RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
