import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AnnounceService } from 'src/app/Services/announce.service';
import { UtilsService } from 'src/app/Services/utils.service';
import { Announce, Car, Product, Address } from '../../Model/Models'

@Component({
  selector: 'app-catalogo-carro',
  templateUrl: './catalogo-carro.component.html',
  styleUrls: ['./catalogo-carro.component.css']
})
export class CatalogoCarroComponent {

  actualPage !: number
  totalOfPages !: number
  arrayOfPages : number[] = []

  //anuncios
  ads: Announce[] = []

  categories : string[] = ['Frontier', 'Hatches', 'New City', 'Suv', 'Jipe', 'Picape', 'Sedan', 'Antigo', 'Esportivo', 'Luxo', 'Eletrico', 'Pcd', 'Popular', 'Outro']
  colors: string[] = ['amarelo','azul','bege','branco','cinza','marrom','preto','verde','vermelho','vinho','prata']
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
    mileage: {
      from: null,
      to: null
    },
    automaker: [],
    color: [],
    condition: [],
    category: []
  };
  
  isBrandShow:boolean = false;
  isColorShow:boolean = false;
  isCategoryShow:boolean = false;
  
  loading:boolean = true;

  constructor(private service: AnnounceService, private router:ActivatedRoute, private utils: UtilsService){
  }

  ngOnInit(): void {
    let loadingChecking = setInterval(()=>{
      if(this.ads.length>0){
        this.hideLoadinGif()
      }
    }, 100)
    setTimeout(()=>{
      clearInterval(loadingChecking)
      this.hideLoadinGif()
    }, 10000)

    
    this.router.queryParams.subscribe(params => {
      if('search' in params){
        this.getAll(params['search'])
      } 
      else if (Object.entries(params).length == 0 && this.isLogged()){
        let id = sessionStorage.getItem('idUser')
        this.service.getAllCarsLocation(id || "").subscribe((data: any) => this.ads = <Announce[]>data.content)
      } else{
        for(let [key, value] of Object.entries(params)){
          this.utils.addValueToObject(this.filters, key, value)
        }
        this.filter()
      }

    });

   
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

  getAll(search){
    this.service.getAllCars(search).subscribe( (data: any) => {
      this.ads = <Announce[]>data.content
      this.totalOfPages = data.totalPages
      for(let i = 0; i < this.totalOfPages ; i++){
        this.arrayOfPages.push(i)
      }
      this.actualPage = 0
    })
  }

  log(){
    console.log(Object.keys(this.filters))
  }

  getCar(data: Product){
    return data as Car
  }

  filter(){
    this.service.getCarsByCriteria(this.filters).subscribe((data: any) => this.ads = <Announce[]>data.content)
  }

  clearAllFilters(){
    window.location.reload()
  }

  addFilterOption(key: any, value: any){
    this.utils.addValueToObject(this.filters, key, value)
    this.filter()
  }

  pagination(number:number){
    this.service.getPageCars(number).subscribe((data: any) => this.ads = <Announce[]>data.content)
    this.actualPage = number
  }
  
  paginationAnt(word : string){
    if(word == 'ant'){
      this.pagination(this.actualPage - 1)
    } else {
      this.pagination(this.actualPage + 1)
    }
  }

  isLogged() : boolean{
    return sessionStorage.getItem('token') ? true : false
  }

  hideLoadinGif(){
    // const loadGif = document.querySelector<HTMLElement>('.loading-gif');
    // loadGif!.style.display = 'none';
    this.loading = false
  }
    
  clickEffect(elem: any){
    let e = elem as HTMLElement
    if(elem instanceof HTMLInputElement){
      e = (elem.parentNode as HTMLElement) || e
    }
    e.classList.toggle('click-effect')
  }

}
