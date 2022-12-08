import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Announce, Part, Product, PartClass } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';
import { PartService } from 'src/app/Services/part.service';


@Component({
  selector: 'app-announce-part',
  templateUrl: './announce-part.component.html',
  styleUrls: ['./announce-part.component.css']
})
export class AnnouncePartComponent {

  announceId !: number
  announce !: Announce
  part !: Part
  image : any
  http: any;
  imageUrl !: string 
  cart: PartClass[] = [];


  constructor(private announceService : AnnounceService, private route: ActivatedRoute, private partService : PartService){
    this.route.params.subscribe(params => this.announceId = params['id']);
  }

  ngOnInit(): void {
    this.announceService.getOne(Number(this.announceId)).subscribe( data => {
      this.announce = data
      this.part = this.getPart(data.product)
      console.log(this.part.automaker)
      this.imageUrl = `https://shopcar-t2.s3.sa-east-1.amazonaws.com/media/img${this.announce.id}`
      this.getImage()
    })
  }

  getPart(data: Product){
    return data as Part
  }

  getImage(){
      this.http.get(`http://localhost:8082/api/v1/image/get/${this.announce.image.id}`).subscribe(
        (data: any) => {
          this.image = data
          console.log(data)
        }
      )
  }

  addToCart(id: number){
    let receivedCart = JSON.parse(localStorage.getItem('cart') || '{}');
    let p = new PartClass();
    this.partService.getOne(id).subscribe(retorno => {
     p = retorno;
          this.cart = receivedCart;
          p.reserved_amount = 1;
          this.cart.push(p);
          localStorage.setItem('cart', JSON.stringify(this.cart));
          window.location.reload();
    },
    error => {
      if (error.status == 401){
        alert("Você precisa estar logado para adicionar produtos ao carrinho");
      }
    });
  }

}
