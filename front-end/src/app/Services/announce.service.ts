import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Announce, AnnounceCarClass, User} from '../Model/Models';
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
  
  getCountCars() {
    return this.http.get<number>("http://localhost:8082/api/v1/announce/cars/count")
  }
  
  getMostClickedCars() {
    return this.http.get<Announce[]>("http://localhost:8082/api/v1/announce/cars/most-clicked")
  }

  getAllCars(search: string="", id : string="") {
    let params = new HttpParams()
    if(search != ""){
      params = params.set('search', search)
    }
    return this.http.get<Announce>("http://localhost:8082/api/v1/announce/cars", {params: params})
  }

  getCarsByCriteria(filters: any) {
    return this.http.post<Announce>("http://localhost:8082/api/v1/announce/cars/filters", filters)
  }

  getAllParts():Observable<Announce[]>{
    return this.http.get<Announce[]>("http://localhost:8082/api/v1/announce/parts")
  }
  
  getAutopartsByCriteria(filters: any) {
    return this.http.post<Announce>("http://localhost:8082/api/v1/announce/parts/filters", filters)
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

  getPageCars(number:number){
    return this.http.get<Announce>(`http://localhost:8082/api/v1/announce/cars?page=${number}`)
  }

  getPageParts(number:number){
    return this.http.get<Announce>(`http://localhost:8082/api/v1/announce/parts?page=${number}`)
  }

  getAllCarsLocation(id:string){
    return this.http.get<Announce>(`http://localhost:8082/api/v1/announce/cars?id=${id}`)
  }
}
