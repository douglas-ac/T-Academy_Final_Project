import { Component } from '@angular/core';
import { AnnounceService } from 'src/app/Services/announce.service';
import { PartService } from 'src/app/Services/part.service';
import { UtilsService } from 'src/app/Services/utils.service';
import { Announce, Car, Product, Address, Part, PartClass } from '../../Model/Models'

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
  cart: PartClass[] = [];

  categories : string[] = ['Amortecedor', 'Climatização', 'Direção', 'Motorização', 'Transmissão', 'Suspensão', 'Frenagem', 'Carroceria', 'Segurança', 'Injeção e ignição', 'Exaustão', 'Elétrica', 'Outro']

  vehicle_types: string[] = ['Caminhao', 'Carro', 'Motocileta', 'Onibus', 'Agro', 'Suv', 'Van', 'Outro']

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

  constructor(private service: AnnounceService, private utils: UtilsService, private partService:PartService){
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

  addToCart(id: number){
    let receivedCart = JSON.parse(localStorage.getItem('cart') || '{}');
    let p = new PartClass();
    this.partService.getOne(id).subscribe(retorno => {
      console.log("amogus");
      p = retorno;
      this.cart = receivedCart;
      p.reserved_amount = 1;
      this.cart.push(p);
      localStorage.setItem('cart', JSON.stringify(this.cart));
      window.location.reload();
    },
    error => {
      if (error.status == 401){
        alert("Você precisa estar logado para adicionar produtos ao carrinho")
      }
    });
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
