import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient,private authService : AuthService) { }

  getAll() {
    return this.http.get<[Comment]>("http://localhost:8082/api/v1/comment")
  }

  getOne(id:number):Observable<Comment>{
    return this.http.get<Comment>(`http://localhost:8082/api/v1/comment/${id}`)
  }

  post(data: Comment){
   // let token = this.authService.getToken()
   // var header = new HttpHeaders({'Authorization': 'Bearer ' + token });
    return this.http.post<Comment>("http://localhost:8082/api/v1/comment",data)
  }

  delete(id:number){
    return this.http.delete(`http://localhost:8082/api/v1/comment/${id}`)
  }
}
