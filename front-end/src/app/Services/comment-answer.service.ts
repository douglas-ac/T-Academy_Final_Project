import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CommentAnswerDtoClass } from '../Model/Models';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class CommentAnswerService {

  constructor(private http: HttpClient, private authService : AuthService) { }

  get(id:number){
    return this.http.get<[CommentAnswerDtoClass]>(`http://localhost:8082/api/v1/comment/${id}`)
  }

  post(data: CommentAnswerDtoClass){
   let token = this.authService.getToken()
   var header = new HttpHeaders({'Authorization': 'Bearer ' + token , 'Content-Type': 'application/json'});
    return this.http.post<CommentAnswerDtoClass>("http://localhost:8082/api/v1/comment/answer", data, { headers: header })
  }

  delete(id:number){
    return this.http.delete(`http://localhost:8082/api/v1/comment/${id}`)
  }

}
