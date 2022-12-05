import { Component } from '@angular/core';
import { AnnounceService } from 'src/app/Services/announce.service';
import { Announce, Car, Product, Address, Part } from '../../Model/Models'

@Component({
  selector: 'app-parts-catalog',
  templateUrl: './parts-catalog.component.html',
  styleUrls: ['./parts-catalog.component.css']
})
export class PartsCatalogComponent {

  ads: Announce[] = []
  itemList: Announce[] = [];

  isBrandShow:boolean = false;
  isMontadoraShow:boolean = false;
  isCategoryShow:boolean = false;
  isVehicleTypeShow:boolean = false;

  constructor(private service: AnnounceService){
    this.getAll()
  }

  showAllBrands(){
    this.isBrandShow = !this.isBrandShow;
  }

  showAllVehicleTypes(){
    this.isVehicleTypeShow = !this.isVehicleTypeShow;
  }

  showAllMontadoras(){
    this.isMontadoraShow = !this.isMontadoraShow;
  }

  showAllCategories(){
    this.isCategoryShow = !this.isCategoryShow;
  }

  getAll(){
    // this.service.getAllCars().subscribe( (data: any) => console.log(data.content))
    this.service.getAllParts().subscribe( (data: any) => this.ads = <Announce[]>data.content)
  }

  getPart(data: Product){
    return data as Part
  }

  log(){
    console.log(this.ads)
  }

  addToCart(id: number){
    let json = JSON.parse(localStorage.getItem('itemList'));
    let an = this.service.getOne(id);
    this.itemList.push(an);
    localStorage.setItem('itemList', JSON.stringify(this.itemList));
  }

}
