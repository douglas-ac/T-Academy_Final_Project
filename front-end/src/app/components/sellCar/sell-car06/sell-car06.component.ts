import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Announce } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';

@Component({
  selector: 'app-sell-car06',
  templateUrl: './sell-car06.component.html',
  styleUrls: ['./sell-car06.component.css']
})
export class SellCar06Component implements OnInit {

  constructor(private servico:AnnounceService) { }

  vetor:Announce[] = [];

  ngOnInit(): void { 
  }

  formulario = new FormGroup({
    cep: new FormControl(),
    rua: new FormControl(),
    numero: new FormControl(),
    bairro: new FormControl(),
    cidade: new FormControl()
  })

  testarFormulario():void {
    console.log(this.formulario);
  }

  // cadastrar():void {
  //   let a = new Announce();

  //   a.cep = this.formulario.value.cep;
  //   a.rua = this.formulario.value.rua;
  //   a.numero = this.formulario.value.numero;
  //   a.bairro = this.formulario.value.bairro;
  //   a.cidade = this.formulario.value.cidade;

  //   this.servico.post(a)
  //   .subscribe(retorno => {
  //     this.vetor.push(retorno);
  //   })

  //   console.log(this.vetor);

  // }

}
