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
  itemsId:number[] = [];

  ngOnInit(){
    this.loadCart();
  }

  loadCart(){
    localStorage.setItem('itemList', JSON.stringify(this.itemsId));
    this.getIds();
    this.addToCart();
  }

  getIds(){
      console.log(localStorage.getItem('itemList'));
      if (localStorage.getItem('itemList') === undefined){
         localStorage.setItem('itemList', JSON.stringify(this.itemsId));
      } else {
        let itemsString = localStorage.getItem('itemList');
        let length = text.split(",");

        this.itemsId = []
        for (let i = 0; i < length; i++){
          //ir apendando pelo splice/split dai
        }
      }

  }

  1,3,4,5,6

  splite()

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
    //verificar estoque no anouncement
  }

  minusOne(c:Part){
    c.amount -= 1;
    if (c.amount == 0){
      this.removeFromCart(c);
    }
  }

  getPrice(c:Part){
    return c.price*c.amount;
  }

  removeFromCart(c:Part){
  let pesquisaId = this.cart.findIndex(obj => {return obj.id === c.id})
  this.cart.splice(pesquisaId, 1);
  this.itemsId.splice(pesquisaId, 1);
  localStorage.setItem('itemList', JSON.stringify(this.itemsId));
  }

  getSubtotal():number{
    let subtotal:number = 0;
    for (let i=0; i<this.itemsId.length; i++){
      subtotal += (this.cart[i].amount+this.cart[i].price);
      subtotal += this.getPrice(this.cart[i]);
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
