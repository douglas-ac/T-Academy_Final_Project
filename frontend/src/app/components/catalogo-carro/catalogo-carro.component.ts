import { Component } from '@angular/core';
import { AnnounceService } from 'src/app/Services/announce.service';
import { Announce, Car, Product, Address } from '../../Model/Models'

@Component({
  selector: 'app-catalogo-carro',
  templateUrl: './catalogo-carro.component.html',
  styleUrls: ['./catalogo-carro.component.css']
})
export class CatalogoCarroComponent {
  ads: Announce[] = []

  isBrandShow:boolean = false;
  isColorShow:boolean = false;
  isCategoryShow:boolean = false;

  constructor(private service: AnnounceService){
    this.getAll()
  }
  
  showAllBrands(){
    this.isBrandShow = !this.isBrandShow;
  }

  showAllColors(){
    this.isColorShow = !this.isColorShow;
  }

  showAllCategorys(){
    this.isCategoryShow = !this.isCategoryShow;
  }

  getAll(){
    // this.service.getAllCars().subscribe( (data: any) => console.log(data.content))
    this.service.getAllCars().subscribe( (data: any) => this.ads = <Announce[]>data.content)
  }

  log(){
    console.log(this.ads)
  }

  getCar(data: Product){
    return data as Car
  }


}
