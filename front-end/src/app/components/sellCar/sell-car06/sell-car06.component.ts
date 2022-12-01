import { Component, OnInit } from '@angular/core';
import { AdressClass, AnnounceCarClass, Car, CarClass, Images, UserClass } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';
import { CarService } from 'src/app/Services/car.service';
import { Router } from '@angular/router';
import { CepService } from 'src/app/Services/cep.service';


@Component({
  selector: 'app-sell-car06',
  templateUrl: './sell-car06.component.html',
  styleUrls: ['./sell-car06.component.css']
})
export class SellCar06Component implements OnInit {

  car : CarClass = new CarClass();

  constructor(private serviceAnnounce:AnnounceService, private serviceCar : CarService, private router : Router, private cepService : CepService) { }

  announce : AnnounceCarClass = new AnnounceCarClass();
  product : CarClass = new CarClass();
  carPosted: CarClass = new CarClass();
  user : UserClass = new UserClass();

  ngOnInit(): void { 
    this.car = this.serviceCar.getCarPage()
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

  continue(){

    this.serviceCar.postImage(this.serviceCar.getImage()).subscribe( response => {
      this.serviceCar.post(this.car).subscribe( data => {
        this.product = data
        this.announce.amount = 1;
  
        this.announce.user = this.user
        this.announce.user.id = 1
        
        this.announce.product = this.product

        this.announce.image.id = response
    
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
          "image" : { "id" : ${this.announce.image.id}
            }
        }`;
        
        console.log(obj)
        this.serviceAnnounce.post(obj).subscribe()
      });
        this.router.navigate(['sell-car07'])
    })
  }
    

  navigate(route : string){
    this.router.navigate([`${route}`])
  }
}

