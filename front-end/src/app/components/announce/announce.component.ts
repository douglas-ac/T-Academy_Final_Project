import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Announce, Car, Product, UserClass } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';
import { CommentService } from 'src/app/Services/comment.service';

@Component({
  selector: 'app-announce',
  templateUrl: './announce.component.html',
  styleUrls: ['./announce.component.css'],
})
export class AnnounceComponent {
  comment!: Comment;
  announceId!: number;
  announce!: Announce;
  car!: Car;
  image: any;
  http: any;

  constructor(
    private announceService: AnnounceService,
    private route: ActivatedRoute,
    private commentService: CommentService
  ) {
    this.route.params.subscribe((params) => (this.announceId = params['id']));
  }

  ngOnInit(): void {
    this.announceService.getOne(Number(this.announceId)).subscribe((data) => {
      this.announce = data;
      this.car = this.getCar(data.product);
      this.getImage();
    });
  }

  getCar(data: Product) {
    return data as Car;
  }

  getImage() {
    this.http
      .get(`http://localhost:8082/api/v1/image/get/${this.announce.image.id}`)
      .subscribe((data: any) => {
        this.image = data;
        console.log(data);
      });
  }

  addComment() {
    let idUser = sessionStorage.getItem('idUser');
    let message = (document.querySelector('#comment-input') as HTMLInputElement)
      .value;
    let annouceId = this.announceId;

    let user = new UserClass()

   // let comment: Comment = {
      
   // }
    
   // this.commentService.post(comment)

    // console.log("Id user: "+idUser + "\n"
    // + "Message: " + message + "\n"
    // + "Id anúncio: " + this.announceId);
  }
}
