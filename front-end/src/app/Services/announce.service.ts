import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Announce, AnnounceCarClass} from '../Model/Models';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AnnounceService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<Announce[]>("http://localhost:8082/api/v1/announce")
  }

  getAllCars() {
    return this.http.get<Announce>("http://localhost:8082/api/v1/announce/cars")
  }

  getAllParts() {
    return this.http.get<Announce[]>("http://localhost:8082/api/v1/announce/parts")
  }

  getOne(id:number){
    return this.http.get<Announce>(`http://localhost:8082/api/v1/announce/${id}`)
  }

  post(data : string){
    return this.http.post<AnnounceCarClass>("http://localhost:8082/api/v1/announce",data , httpOptions)
  }
  
  delete(id:number){
    return this.http.delete(`http://localhost:8082/api/v1/announce/${id}`)
  }
}
