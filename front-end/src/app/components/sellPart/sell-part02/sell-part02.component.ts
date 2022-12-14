 import { Component, OnInit } from '@angular/core';
 import { FormControl, FormGroup, Validators } from '@angular/forms';
 import { Router } from '@angular/router';
 import { AdressClass, AnnouncePartClass, PartClass, Images, UserClass, CarClass } from 'src/app/Model/Models';
 import { AnnounceService } from 'src/app/Services/announce.service';
 import { PartService } from 'src/app/Services/part.service';
 import { CepService } from 'src/app/Services/cep.service';
import { AuthService } from 'src/app/Services/auth.service';
import { CarService } from 'src/app/Services/car.service';

 @Component({
   selector: 'app-sell-part02',
   templateUrl: './sell-part02.component.html',
   styleUrls: ['./sell-part02.component.css']
 })
 export class SellPart02Component implements OnInit {
   sent: boolean = false

   //classes used to build object
   announce : AnnouncePartClass = new AnnouncePartClass();
   part : PartClass = new PartClass();
   user : UserClass = new UserClass();
   car : CarClass = new CarClass();

   //params for option in html
   years : number[] = []
   categorys : string[] = ['Frontier', 'Hatches', 'New City', 'Suv', 'Jipe', 'Picape', 'Sedan', 'Antigo', 'Esportivo', 'Luxo', 'Eletrico', 'Pcd', 'Popular', 'Outro']
   categories : string[] = ['Amortecedor', 'Climatização', 'Direção', 'Motorização', 'Transmissão', 'Suspensão', 'Frenagem', 'Carroceria', 'Segurança', 'Injeção e ignição', 'Exaustão', 'Elétrica', 'Outro']
   partmakers : object = {};
   automakers : object = {};

   constructor(private carService:CarService, private PartService : PartService, private router : Router,
               private cepService : CepService, private announceService : AnnounceService, private authService : AuthService) { }

   AnnounceForm = new FormGroup ({
     brand: new FormControl('', [Validators.required]),
     model: new FormControl('', [Validators.required]),
     color: new FormControl('', [Validators.required]),
     year: new FormControl('', [Validators.required]),
     category: new FormControl('', [Validators.required]),
     quilometragem: new FormControl('', [Validators.required, Validators.pattern('[0-9]{1,}.[0-9]{3} +km+$')]),
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
     this.PartService.getPartPage()

     this.PartService.getPartmakers().subscribe(data => {
       this.partmakers = data
     })

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

     this.saveImage()
     this.PartService.postImage(this.PartService.getImage()).subscribe( response => {
       this.PartService.post(this.part).subscribe( data => {
         this.part = data
         this.announce.amount = 1;

         this.announce.user = this.user
         this.announce.user.id = Number(this.authService.getId())

         this.announce.product = this.part

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
         this.announceService.post(obj).subscribe()
       });
         this.router.navigate(['sell-part06'])
     })
   }


   saveImage(){
     const form : any = document.getElementById("form");
     const inputFile : any = document.getElementById("file");

     const formData = new FormData();

     for (const file of inputFile.files) {
       formData.append("image", file);

     }

     this.PartService.saveImage(formData)
   }
 }
