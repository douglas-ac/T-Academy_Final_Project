import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { User, Login, AnnouncementList, Adress } from "../Model/Models"

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  post(data: User){
    return this.http.post<User>("http://localhost:8082/api/v1/user", data)
  }

  getOne(id:number){
    return this.http.get<[User]>(`http://localhost:8082/api/v1/user/${id}`)
  }

  put(id:number, data:User){
    return this.http.put<[User]>(`http://localhost:8082/api/v1/user/${id}`, data)
  }
}
