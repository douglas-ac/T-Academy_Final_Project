import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Announce, Car, Product, User } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';
import { UserService } from 'src/app/Services/user.service'

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  anuncios:Announce[] = [];
  itensId:number[] = [];
  vetor:Announce[] = [];

  teste:boolean = false;

  usuario:string = "";
  username:string = "";
  user:User = <User> {
    name: '',
    email: '',
    fone: ''
  }
  
  constructor(private servico : AnnounceService, private route: ActivatedRoute, private userService:UserService){
    this.usuario = sessionStorage.getItem("idUser") || "";
    this.username = sessionStorage.getItem("username") || "";
  }

  ngOnInit(): void {
    this.userService.getOne(Number(this.usuario)).subscribe(data => {
      this.user = data;
    })
  }

  remover(id:number) {
    let confirmado = confirm("Você tem certeza de que quer remover esse anúncio? Esta ação não pode ser desfeita.");

    if (confirmado == true) {
      this.servico.delete(id).subscribe(() => {
        let arr = this.user.announcementList || []
        let index = arr.findIndex(ad => {return ad.id === id});
        if (index > -1) {
          arr.splice(index, 1);
        }
  
      })
    }
 
  }

  selecionar():void {
    this.servico.getAll().subscribe({
      next: retorno => this.anuncios = retorno
    })
    
  }

  listar():void {
    let usuario = parseInt(this.usuario);

    for (let i = 0; i < this.anuncios.length; i++) {
      if (this.anuncios[i].user.id == usuario) {
        this.vetor.push(this.anuncios[i]);
      }
    }

  }

  redirecionar() {
    window.location.href="login";
  }

  getCar(data: Product){
    return data as Car
  }
}
