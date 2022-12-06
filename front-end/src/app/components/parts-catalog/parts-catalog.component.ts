import { Component } from '@angular/core';
import { AnnounceService } from 'src/app/Services/announce.service';
import { PartService } from 'src/app/Services/part.service';
import { Announce, Car, Product, Address, Part, PartClass } from '../../Model/Models'

@Component({
  selector: 'app-parts-catalog',
  templateUrl: './parts-catalog.component.html',
  styleUrls: ['./parts-catalog.component.css']
})
export class PartsCatalogComponent {

  ads: Announce[] = []
  cart: PartClass[] = [];

  isBrandShow:boolean = false;
  isMontadoraShow:boolean = false;
  isCategoryShow:boolean = false;
  isVehicleTypeShow:boolean = false;

  constructor(private service:AnnounceService, private partService:PartService){
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
    let receivedCart = JSON.parse(localStorage.getItem('cart') || '{}');
    let p = new PartClass();
    this.partService.getOne(id).subscribe(retorno => {
      p = retorno;
      this.cart = receivedCart;
      p.reserved_amount = 1;
      this.cart.push(p);
      localStorage.setItem('cart', JSON.stringify(this.cart));
      window.location.reload();
    });
  }

}
