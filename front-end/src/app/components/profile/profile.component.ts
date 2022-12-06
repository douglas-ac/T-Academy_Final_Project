import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Announce, Car, Product } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  username:string = sessionStorage.getItem('username');
  id:number;
  valor:string;
  http:any;

  anuncios:Announce[] = [];
  itensId:number[] = [];

  constructor(private announceService : AnnounceService, private route: ActivatedRoute){
    this.route.params.subscribe(params => this.id = params['id']);
  }

  ngOnInit(): void {
    this.announceService.getOne(Number(this.id)).subscribe( data => {
      this.announce = data
      this.car = this.getCar(data.product)
      this.getImage()
    })
  }

  remover(id:number) {
    let opcao = confirm("Você realmente quer excluir esse anúncio? Esta ação não poderá ser desfeita.");

    if (opcao) {
      this.http.delete(`http://localhost:8082/api/v1/announce/${id}`);
    }

  }

  removeFromCart(a:Announce){
    let pesquisaId = this.anuncios.findIndex(obj => {return obj.id === a.id})
    this.anuncios.splice(pesquisaId, 1);
  }

}
