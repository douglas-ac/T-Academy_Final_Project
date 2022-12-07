import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Announce, AnnounceClass, Car, CommentClass, Product, UserClass } from 'src/app/Model/Models';
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
  comments: CommentClass[] = []

  constructor(
    private announceService: AnnounceService,
    private route: ActivatedRoute,
    private commentService: CommentService
  ) {
    this.route.params.subscribe((params) => (this.announceId = params['id']));
    this.getComment()
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
    let idUser = sessionStorage.getItem('idUser') || ''
    let message = (document.querySelector('#comment-input') as HTMLInputElement)
      .value;
    let annouceId = this.announceId ;

    let user = new UserClass()
    let comment = new CommentClass()
    let announce = new AnnounceClass()

    user.id = Number(idUser)
    announce.id = annouceId

    comment.user = user
    comment.message = message
    comment.announcement = announce
    
   this.commentService.post(comment).subscribe(() => {})

   console.log(comment)
  }

  getComment() {
    this.commentService.getAll()
    .subscribe({
      next: data => this.comments = data,
      error: () => alert("falha")

    })
  }
}
