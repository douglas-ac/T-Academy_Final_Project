import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Part, PartClass } from '../Model/Models';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class PartService {

  part:PartClass = new PartClass();
  images:any;

  constructor(private http: HttpClient,private authService : AuthService) { }

  getAll() {
    return this.http.get<[Part]>("http://localhost:8082/api/v1/parts")
  }

  getOne(id:number):Observable<Part>{
    let token = this.authService.getToken();
    var header = new HttpHeaders({'Authorization': 'Bearer' + token });
    return this.http.get<Part>(`http://localhost:8082/api/v1/parts/${id}`, { headers: header });
  }

  post(data: Part){
    let token = this.authService.getToken()
    var header = new HttpHeaders({'Authorization': 'Bearer ' + token });
    return this.http.post<Part>("http://localhost:8082/api/v1/parts",data, { headers: header })
  }

  put(id:number, data:Part){
    return this.http.put<[Part]>(`http://localhost:8082/api/v1/parts/${id}`, data)
  }

  getPartmakers() {
    return this.http.get<Object>("http://localhost:8082/api/v1/parts/partmakers")
  }

  delete(id:number){
    return this.http.delete(`http://localhost:8082/api/v1/parts/${id}`)
  }

  getPartPage() {
    return this.part;
  }

  postImage(image : FormData){
    return this.http.post<number>("http://localhost:8082/api/v1/image/upload",image)
  }

  getImage() {
    return this.images
  }

  saveImage(image : any){
    this.images = image
  }

}
