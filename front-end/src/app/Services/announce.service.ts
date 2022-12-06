import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Announce, AnnounceCarClass} from '../Model/Models';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AnnounceService {

  token = sessionStorage.getItem('token')

  constructor(private http: HttpClient, private authService : AuthService) { }

  getAll() {
    return this.http.get<Announce[]>("http://localhost:8082/api/v1/announce")
  }

  getAllCars() {
    return this.http.get<Announce>("http://localhost:8082/api/v1/announce/cars")
  }

  getCarsByCriteria(filters: any) {
    return this.http.post<Announce>("http://localhost:8082/api/v1/announce/cars/filters", filters)
  }

  getAllParts():Observable<Announce[]>{
    return this.http.get<Announce[]>("http://localhost:8082/api/v1/announce/parts")
  }

  getOne(id:number){
    return this.http.get<Announce>(`http://localhost:8082/api/v1/announce/${id}`)
  }

  post(data : string){
    let token = this.authService.getToken()
    var header = new HttpHeaders({'Authorization': 'Bearer ' + token , 'Content-Type': 'application/json'});
    return this.http.post<AnnounceCarClass>("http://localhost:8082/api/v1/announce",data , { headers: header })
  }

  delete(id:number){
    return this.http.delete(`http://localhost:8082/api/v1/announce/${id}`)
  }
}
