import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Announce, AnnounceClass, Car, CommentAnswerDto, CommentAnswerDtoClass, CommentClass, Product, UserClass } from 'src/app/Model/Models';
import { AnnounceService } from 'src/app/Services/announce.service';
import { CommentAnswerService } from 'src/app/Services/comment-answer.service';
import { CommentService } from 'src/app/Services/comment.service';

@Component({
  selector: 'app-announce',
  templateUrl: './announce.component.html',
  styleUrls: ['./announce.component.css'],
})
export class AnnounceComponent {
  comment!: Comment;
  announceId!: number;
  announce !: Announce 
  car!: Car;
  image: any;
  http: any;
  comments: CommentClass[] = []
  commentAnswer: CommentAnswerDtoClass[] = []
  userId = sessionStorage.getItem('idUser') || ''
  id = Number(this.userId)
  imageUrl !: string 
  isLogged: boolean = false;

  constructor(
    private announceService: AnnounceService,
    private route: ActivatedRoute,
    private commentService: CommentService,
    private commentAnswerService: CommentAnswerService
  ) {
    this.route.params.subscribe((params) => (this.announceId = params['id']));
    this.getComment()
  }

  ngOnInit(): void {
    this.announceService.getOne(Number(this.announceId)).subscribe((data) => {
      this.announce = data;
      this.car = this.getCar(data.product);
      this.imageUrl = `https://shopcar-t2.s3.sa-east-1.amazonaws.com/media/img${this.announce.id}`
      this.userIsLogged()
    });
  }

  userIsLogged() {
    let token = sessionStorage.getItem('token')

    if (token != null) {
      this.isLogged = true
    } 
  }

  getCar(data: Product) {
    return data as Car;
  }

  addComment() {
    let idUser = sessionStorage.getItem('idUser') || ''
    let message = (document.querySelector('#comment-input') as HTMLInputElement)
      .value;
    let annouceId = this.announceId ;

    let user = new UserClass()
    let comment = new CommentClass()
    let announce = new AnnounceClass()
    let date = new Date()

    user.id = Number(idUser)
    announce.id = annouceId
    date.getDate()

    comment.user = user
    comment.message = message
    comment.announcement = announce
    comment.time = date
    
    this.commentService.post(comment).subscribe(() => {})

   console.log(comment)
   window.location.href = window.location.href;
  }

  getComment() {
    this.commentService.getOne(this.announceId)
    .subscribe({
      next: data => this.comments = data,
      error: () => console.log("falha")
    })
  }

  addCommentAnswer(id: number) {
    let message = (document.querySelector('#comment-answer'+id) as HTMLInputElement).value;
    let date = new Date()
    date.getDate()

    let idUser = sessionStorage.getItem('idUser') || ''
    let user = new UserClass()
    user.id = Number(idUser)

    let comment = new CommentClass()
    comment.id = id

    let commentAnswer = new CommentAnswerDtoClass()
    commentAnswer.message = message
    commentAnswer.timeCreated = date
    commentAnswer.user = user
    commentAnswer.comment = comment

    this.commentAnswerService.post(commentAnswer).subscribe(() => {})  
    window.location.href = window.location.href;
  }

  deleteComment(id: number) {
    this.commentService.delete(id)
    .subscribe(() => {})
    window.location.href = window.location.href;
  }

  haveToken():boolean{
    if (sessionStorage.getItem('token') == undefined){
      return false;
    } else {
      return true;
    }
  }

}
