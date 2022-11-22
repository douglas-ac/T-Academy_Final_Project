import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogoCarroComponent } from './components/catalogo-carro/catalogo-carro.component';

const routes: Routes = [
  {path: 'catalogoCarros', component: CatalogoCarroComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
