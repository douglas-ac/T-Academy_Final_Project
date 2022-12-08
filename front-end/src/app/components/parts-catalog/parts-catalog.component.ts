import { Component } from '@angular/core';
import { AnnounceService } from 'src/app/Services/announce.service';
import { UtilsService } from 'src/app/Services/utils.service';
import { Announce, Car, Product, Address, Part } from '../../Model/Models'

@Component({
  selector: 'app-parts-catalog',
  templateUrl: './parts-catalog.component.html',
  styleUrls: ['./parts-catalog.component.css']
})
export class PartsCatalogComponent {

  //pagination
  actualPage !: number
  totalOfPages !: number
  arrayOfPages : number[] = []

  ads: Announce[] = []

  // Filters' options
  filters = {
    name: null,
    location: null,
    year: {
      from: null,
      to: null
    },
    price: {
      from: null,
      to: null
    },
    automaker: [],
    category: [],
    part_condition: [],
    brand: [],
    vehicle_type: []
  };  

  isBrandShow:boolean = false;
  isMontadoraShow:boolean = false;
  isCategoryShow:boolean = false;
  isVehicleTypeShow:boolean = false;

  constructor(private service: AnnounceService, private utils: UtilsService){
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

  showAllCategorys(){
    this.isCategoryShow = !this.isCategoryShow;
  }

  getAll(){
    this.service.getAllParts().subscribe( (data: any) => {
      this.ads = <Announce[]>data.content
      this.totalOfPages = data.totalPages
      for(let i = 0; i < this.totalOfPages ; i++){
        this.arrayOfPages.push(i)
      }
      this.actualPage = 0
    })
  }

  getPart(data: Product){
    return data as Part
  }

  log(){
    console.log(this.ads)
  }

  filter(){
    this.service.getAutopartsByCriteria(this.filters).subscribe((data: any) => this.ads = <Announce[]>data.content)
  }

  clearAllFilters(){
    window.location.reload()
  }

  addFilterOption(key: any, value: any){
    this.utils.addValueToObject(this.filters, key, value)
    this.filter()
  }

  pagination(number:number){
    this.service.getPageParts(number).subscribe((data: any) => this.ads = <Announce[]>data.content)
    this.actualPage = number
  }
  
  paginationAnt(word : string){
    if(word == 'ant'){
      this.pagination(this.actualPage - 1)
    } else {
      this.pagination(this.actualPage + 1)
    }
  }

}
