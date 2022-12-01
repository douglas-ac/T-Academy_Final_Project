import { Component } from '@angular/core';
//import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Part } from 'src/app/Model/Models';
import { PartService } from 'src/app/Services/part.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  constructor(private servico:PartService){}

  cart:Part[] = [];
  itemsId:number[] = [4, 12, 13];
  //zerar depois ^^, usar o de baixo com input/output

  ngOnInit(){
  this.addToCart();
  }

  addToCart():void{
    for (let i=0; i<this.itemsId.length; i++){
      this.servico.getOne(this.itemsId[i])
      .subscribe(retorno => {
      console.log(retorno);
      retorno.amount=1;
      this.cart.push(retorno);
      })
    }
  console.log(this.cart);
  }


  plusOne(c:Part){
    c.amount += 1;
    //verificar estoque qnd implementado
  }

  minusOne(c:Part){
    c.amount -= 1;
    if (c.amount == 0){
      this.removeFromCart(c);
    }
  }

  removeFromCart(c:Part){
  let pesquisaId = this.cart.findIndex(obj => {return obj.id === c.id})
  this.cart.splice(pesquisaId, 1);
  }

  getSubtotal():number{
    let subtotal:number = 0;
    for (let i=0; i<this.itemsId.length; i++){
      subtotal += (this.cart[i].amount+this.cart[i].price);
    }
    return subtotal;
  }

  getShippingPrice():number{
    let shippingPrice = 25;
    return shippingPrice;
  }
  //ajustar ^^

  getTotal():number{
    return (this.getSubtotal() + this.getShippingPrice());
  }

}
