import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdressClass, AnnounceCarClass, CarClass, Images, UserClass } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';
import { CarService } from 'src/app/Services/car.service';
import { CepService } from 'src/app/Services/cep.service';

@Component({
  selector: 'app-sell-car02',
  templateUrl: './sell-car02.component.html',
  styleUrls: ['./sell-car02.component.css']
})
export class SellCar02Component implements OnInit {
  sent: boolean = false

  //classes used to build object
  announce : AnnounceCarClass = new AnnounceCarClass();
  car : CarClass = new CarClass();
  user : UserClass = new UserClass();

  //params for option in html
  years : number[] = []
  categorys : string[] = ["Hatch", "Sedan", "SUV", "Cupê", "Pick-up", "Conversivel", "Minivan", "Van" , "Station Wagon", "Outro"]
  automakers : String[] = [] 
  
  constructor(private carService : CarService, private router : Router,
              private cepService : CepService, private announceService : AnnounceService) { }

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

  registerAnnounce(){
    this.sent = true
      this.carService.post(this.car).subscribe( data => {
        this.car = data
        this.announce.amount = 1;
  
        this.announce.user = this.user
        this.announce.user.id = 1
        
        this.announce.product = this.car
    
        var obj = 
        `{   
          "user" : {"id" : ${this.announce.user.id}},
          "amount" : 1,
          "product" : {"id" : ${this.announce.product.id}},
          "address" : {
            "cep" : "${this.announce.adress.cep}",
            "localidade" : "${this.announce.adress.localidade}",
            "bairro" : "${this.announce.adress.bairro}",
            "logradouro" : "${this.announce.adress.logradouro}",
            "complemento" : "${this.announce.adress.complemento}",
            "uf" : "${this.announce.adress.uf}"
          },
          "image" : { "id" : 0
            }
        }`;
        
        console.log(obj)
        this.announceService.post(obj).subscribe()
      });
        this.router.navigate(['sell-car07'])
    }
}

