import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdressClass, AnnounceCarClass, CarClass, Images, UserClass } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';
import { CarService } from 'src/app/Services/car.service';
import { CepService } from 'src/app/Services/cep.service';

@Component({
  selector: 'app-editar-anuncio',
  templateUrl: './editar-anuncio.component.html',
  styleUrls: ['./editar-anuncio.component.css']
})
export class EditarAnuncioComponent implements OnInit {
  
  sent: boolean = false

  //announceId
  announceId !: number

  //images 
  selectedFiles!: FileList;

  //classes used to build object
  announce : AnnounceCarClass = new AnnounceCarClass();
  car : CarClass = new CarClass();
  user : UserClass = new UserClass();

  //params for option in html
  years : number[] = []
  categorys : string[] = ['Frontier', 'Hatches', 'New City', 'Suv', 'Jipe', 'Picape', 'Sedan', 'Antigo', 'Esportivo', 'Luxo', 'Eletrico', 'Pcd', 'Popular', 'Outro']
  automakers : object = {}
  
  constructor(  private carService : CarService,
                private router : Router,
                private cepService : CepService, 
                private announceService : AnnounceService, 
                private route: ActivatedRoute) 
                { this.route.params.subscribe((params) => (this.announceId = params['id'])); }

  AnnounceForm = new FormGroup ({
    brand: new FormControl('', [Validators.required]),
    model: new FormControl('', [Validators.required]),
    color: new FormControl('', [Validators.required]),
    year: new FormControl('', [Validators.required]),
    category: new FormControl('', [Validators.required]),
    quilometragem: new FormControl('', [Validators.required, Validators.pattern('[0-9]{1,}.[0-9]{3} +km$')]),
    description: new FormControl('', [Validators.required]),
    price: new FormControl('', [Validators.required, Validators.pattern('RS [0-9]{1,3}.[0-9]{3}')]),
    cep: new FormControl('', [Validators.required]),
    logradouro: new FormControl('', [Validators.required]),
    bairro: new FormControl('', [Validators.required]),
    localidade: new FormControl('', [Validators.required]),
    uf: new FormControl('', [Validators.required]),
    complemento: new FormControl()
  })


  ngOnInit( ): void {
    this.carService.getCarPage()

    this.carService.getAutomakers().subscribe(data => {
      this.automakers = data
    })
    
    for(let i=1920 ; i<= 2023 ; i++){
      this.years.push(i)
    }
    this.years = this.years.reverse()

    this.announce.adress = new AdressClass();
    this.announce.image = new Images();

    this.announceService.getOne(this.announceId).subscribe( data => {
      let carToChange = this.getCar(data.product)
      this.car = carToChange
  
      this.announce.adress = data.address
    })
  }

  atualizarCep(){
    this.cepService.getCep(Number(this.announce.adress.cep)).subscribe(
      data => {
        this.announce.adress.bairro = data.bairro
        this.announce.adress.localidade = data.localidade
        this.announce.adress.uf = data.uf
        this.announce.adress.logradouro = data.logradouro
      }
    )
  }

  updateAnnounce(){
    this.sent = true

    this.announce.product = this.car
    let userId = sessionStorage.getItem('idUser')

    this.carService.put(this.announce.product.id, this.car).subscribe( data => {
      this.announce.product = data 
      this.router.navigateByUrl(`anuncio/${this.announceId}`)
    })
    }

      getCar(data : any){
        return data as CarClass
      }

  }

