import { Component } from '@angular/core';
import { AnnouncePartClass, PartClass } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';
import { PartService } from 'src/app/Services/part.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  constructor(private announceService:AnnounceService, private partService:PartService){}

  cart:PartClass[] = [];
  shippingPrice:number=0;

  ngOnInit(){
    if (localStorage.getItem('cart') == undefined){
      localStorage.setItem('cart', JSON.stringify(this.cart));
    }
    this.getItems();
  }

  getItems():void{
      let receivedCart:PartClass[] = JSON.parse(localStorage.getItem('cart') || '{}' );
      this.cart = receivedCart;
      localStorage.setItem('cart', JSON.stringify(this.cart));
  }

  getAnnounce(id:number):any{
    this.announceService.getAllParts()
    .subscribe(dados => {
      console.log(dados)
      for (let i=0;i<dados.length;i++){
        if (dados[i].product.id == id){
          return dados[i];
        }
      }
    });
    return false;
  }

  plusOne(c:PartClass):void{
    let an : AnnouncePartClass = this.getAnnounce(c.id);
    if (c.reserved_amount < an.amount){
      c.reserved_amount += 1;
    } else {
      alert("Você já reservou o máximo em estoque")
    }
    localStorage.setItem('cart', JSON.stringify(this.cart));
  }

  minusOne(c:PartClass):void{
    c.reserved_amount -= 1;
    if (c.reserved_amount == 0){
      this.removeFromCart(c);
      localStorage.setItem('cart', JSON.stringify(this.cart));
    }
  }

  removeFromCart(c:PartClass):void{
    let pesquisaId = this.cart.findIndex(obj => {return obj.id === c.id})
    this.cart.splice(pesquisaId, 1);
    localStorage.setItem('cart', JSON.stringify(this.cart));
  }

  getPrice(c:PartClass):number{
    return c.price*c.reserved_amount;
  }


  getSubtotal():number{
    let subtotal:number = 0;
    for (let i=0; i<this.cart.length; i++){
      subtotal += this.getPrice(this.cart[i]);
    }
    return subtotal;
  }

  getShippingPrice():void{
    this.shippingPrice = 18.65;
    //mockado por falta de tempo, existe backup do método pro back, só n teve tempo de ser testado
  }

  getTotal():number{
    return (this.getSubtotal() + this.shippingPrice);
  }

}
