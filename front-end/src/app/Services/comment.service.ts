import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CommentClass } from '../Model/Models';

import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient,private authService : AuthService) { }

  getAll() {
    return this.http.get<[CommentClass]>("http://localhost:8082/api/v1/comment")
  }

  getOne(id:number){
    return this.http.get<[CommentClass]>(`http://localhost:8082/api/v1/comment/${id}`)
  }

  post(data: CommentClass){
   let token = this.authService.getToken()
   var header = new HttpHeaders({'Authorization': 'Bearer ' + token , 'Content-Type': 'application/json'});
    return this.http.post<CommentClass>("http://localhost:8082/api/v1/comment", data, { headers: header })
  }

  delete(id:number){
    return this.http.delete(`http://localhost:8082/api/v1/comment/${id}`)
  }
}
