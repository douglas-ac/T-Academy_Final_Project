 import { Component, OnInit } from '@angular/core';
 import { FormControl, FormGroup, Validators } from '@angular/forms';
 import { Router } from '@angular/router';
 import { AdressClass, AnnouncePartClass, PartClass, Images, UserClass, CarClass } from 'src/app/Model/Models';
 import { AnnounceService } from 'src/app/Services/announce.service';
 import { PartService } from 'src/app/Services/part.service';
 import { CepService } from 'src/app/Services/cep.service';
import { AuthService } from 'src/app/Services/auth.service';
import { CarService } from 'src/app/Services/car.service';
import { UploadService } from 'src/app/Services/upload.service';

 @Component({
   selector: 'app-sell-part02',
   templateUrl: './sell-part02.component.html',
   styleUrls: ['./sell-part02.component.css']
 })
 export class SellPart02Component implements OnInit {
   sent: boolean = false
   selectedFiles!: FileList;

   //classes used to build object
   announce : AnnouncePartClass = new AnnouncePartClass();
   part : PartClass = new PartClass();
   user : UserClass = new UserClass();

   //params for option in html
   years : number[] = []
   vehicle_types: string[] = ['Caminhao', 'Carro', 'Motocileta', 'Onibus', 'Agro', 'Suv', 'Van', 'Outro']
   categories : string[] = ['Amortecedor', 'Climatização', 'Direção', 'Motorização', 'Transmissão', 'Suspensão', 'Frenagem', 'Carroceria', 'Segurança', 'Injeção e ignição', 'Exaustão', 'Elétrica', 'Outro']
   partmakers : object = {};
   automakers : object = {};
   conditions : string[] = ['NOVO', 'USADO'];


   constructor(private carService:CarService, private PartService : PartService, private router : Router, private serviceUploadPhoto : UploadService,
               private cepService : CepService, private announceService : AnnounceService, private authService : AuthService) { }

   AnnounceForm = new FormGroup ({
     brand: new FormControl('', [Validators.required]),
     model: new FormControl('', [Validators.required]),
     year: new FormControl('', [Validators.required]),
     category: new FormControl('', [Validators.required]),
     description: new FormControl('', [Validators.required]),
     price: new FormControl('', [Validators.required, Validators.pattern('RS [0-9]{1,3}.[0-9]{3}')]),
     cep: new FormControl('', [Validators.required]),
     logradouro: new FormControl('', [Validators.required]),
     bairro: new FormControl('', [Validators.required]),
     localidade: new FormControl('', [Validators.required]),
     uf: new FormControl('', [Validators.required]),
     complemento: new FormControl(),
     vehicleType: new FormControl('', [Validators.required]),
     part_condition: new FormControl('', [Validators.required]),
     automaker: new FormControl('', [Validators.required])
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

        
         this.PartService.post(this.part).subscribe( data => {
           this.part = data
           this.announce.amount = 1;

           this.announce.user = this.user
           this.announce.user.id = Number(sessionStorage.getItem("idUser"))

           this.announce.product = this.part

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
             }
            }`;

          //  console.log(obj)
           this.announceService.post(obj).subscribe( (data:any) => {
            debugger
            if (this.selectedFiles != undefined && this.selectedFiles.length > 0){
              this.serviceUploadPhoto.id = data.id
              this.upload()
              }
             this.router.navigate(['sell-part06'])
            })
         });
       }

  upload() : string {
    const file = this.selectedFiles.item(0);
    let location = this.serviceUploadPhoto.uploadFile(file);
    return location as any as string
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
    }

 }
