import { Component } from '@angular/core';
import { Announce, Part } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';
import { PartService } from 'src/app/Services/part.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  constructor(private announceService:AnnounceService, partService:PartService){}

  cart:Part[] = [];
  itemList:Announce[] = [];

  ngOnInit(){
    localStorage.setItem('itemList', this.itemsId.toString());
    this.loadCart();
  }

  loadCart():void{
    localStorage.setItem('itemList', this.itemsId.toString());
    this.getItems();
    this.addToCart();
  }

  getItems():void{
      console.log(localStorage.getItem('itemList'));
      console.log(this.itemsId);
//       if (localStorage.getItem('itemList') === undefined || localStorage.getItem('itemList') === null){
//          localStorage.setItem('itemList', JSON.stringify(this.itemsId));
//       } else {
        let itemsString:string = JSON.stringify(localStorage.getItem('itemList'))
        let itemsArray = itemsString.split(",");
        this.itemsId = []
        for (let i = 0; i < itemsArray.length; i++){
          this.itemsId.push(parseInt(itemsArray[i]));
        }
      }
        console.log(this.itemsId);
        localStorage.setItem('itemList', this.itemsId.toString());
  }

  addToCart():void{
    for (let i=0; i<this.itemsId.length; i++){
      this.partService.getOne(this.itemsId[i].id)
      .subscribe(retorno => {
      console.log(retorno);
      retorno.product.reserved_amount=1;
      this.cart.push(retorno);
      })
    }
  console.log(this.cart);
  }

  getPartOnCart(c:Announce):Part{
    for (i=0;i<cart.length;i++){
      if (c.product.id == cart[i].id){
        console.log("alo diabo");
        return cart[i];
      }
    }
  }


  plusOne(c:Announce):void{
    let part : Part = this.getPartOnCart(c);
    if (part.reserved_amount < c.amount){
      part.reserved_amount += 1;
    } else {
      alert("Você já reservou o máximo em estoque")
    }
    // talvez precise mexer no localStorage
  }

  minusOne(c:Announce):void{
    let part : Part = this.getPartOnCart(c);
      part.reserved_amount -= 1;
    if (c.amount == 0){
      this.removeFromCart(c);
      // talvez precise mexer no localStorage
    }
  }

  getPrice(c:announce):number{
    let part : Part = this.getPartOnCart(c);
    return part.price*part.reserved_amount;
  }

  removeFromCart(c:Announce):void{
    let pesquisaId = this.cart.findIndex(obj => {return obj.id === c.product.id})
    this.cart.splice(pesquisaId, 1);
    this.itemsId.splice(c.id, 1);
    localStorage.setItem('itemList', JSON.stringify(this.itemsId));
  }

  getSubtotal():number{
    let subtotal:number = 0;
    for (let i=0; i<this.itemList.length; i++){
      subtotal += this.getPrice(this.itemList[i]);
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
