import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { User, Login, AnnouncementList, Address } from "../Model/Models"
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private authService : AuthService) { }

  post(data: User){
    return this.http.post<User>("http://localhost:8082/api/v1/user", data)
  }

  getOne(id:number){
    let token = this.authService.getToken()
    var header = new HttpHeaders({'Authorization': 'Bearer ' + token });
    return this.http.get<User>(`http://localhost:8082/api/v1/user/${id}`, { headers: header })
  }

  put(id:number, data:User){
    let token = this.authService.getToken()
    var header = new HttpHeaders({'Authorization': 'Bearer ' + token });
    return this.http.put<[User]>(`http://localhost:8082/api/v1/user/${id}`, data , { headers: header })
  }

  login(username : string, password:string){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('shopcar:shopcar123') });
    headers.append('Content-Type', 'application/x-www-form-urlencoded')   

    const body = new FormData();
    body.append('grant_type','password');
    body.append('username',`${username}`);
    body.append('password',`${password}`);

    return this.http.post('http://localhost:8082/oauth/token', body , {headers});
  }
}
