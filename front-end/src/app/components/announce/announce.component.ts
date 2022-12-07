import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Announce, Car, Product } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';

@Component({
  selector: 'app-announce',
  templateUrl: './announce.component.html',
  styleUrls: ['./announce.component.css']
})
export class AnnounceComponent {

  announceId !: number
  announce !: Announce 
  car !: Car
  image : any
  http: any;

  imageUrl !: string 

  constructor(private announceService : AnnounceService, private route: ActivatedRoute){
    this.route.params.subscribe(params => this.announceId = params['id']);
  }

  ngOnInit(): void {
    this.announceService.getOne(Number(this.announceId)).subscribe( data => {
      this.announce = data
      this.car = this.getCar(data.product)
      this.imageUrl = `https://shopcar-t2.s3.sa-east-1.amazonaws.com/media/img${this.announce.id}`
    })
  }

  getCar(data: Product){
    return data as Car
  }

<<<<<<< HEAD
  getImage(){
      this.http.get(`http://localhost:8082/api/v1/announce/${this.announce.image.id}`).subscribe(
        (data: any) => {
          this.image = data
          console.log(data)
        }
      )
  }
=======
>>>>>>> changePassword
}
