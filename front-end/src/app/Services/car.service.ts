import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Car, CarClass, Images } from '../Model/Models';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  car : CarClass = new CarClass();
  images : any 

  constructor(private http: HttpClient,private authService : AuthService ) { }

  getAll() {
    return this.http.get<[Car]>("http://localhost:8082/api/v1/cars")
  }

  getOne(id:number){
    return this.http.get<[Car]>(`http://localhost:8082/api/v1/cars/${id}`)
  }

  getAutomakers() {
    return this.http.get<Object>("http://localhost:8082/api/v1/cars/automakers")
  }

  post(data: Car){
    let token = this.authService.getToken()
    var header = new HttpHeaders({'Authorization': 'Bearer ' + token });
    return this.http.post<Car>("http://localhost:8082/api/v1/cars",data, { headers: header })
  }

  put(id:number, data:CarClass){
    let token = this.authService.getToken()
    var header = new HttpHeaders({'Authorization': 'Bearer ' + token });
    return this.http.put<[Car]>(`http://localhost:8082/api/v1/cars/${id}`, data, { headers: header })
  }

  delete(id:number){
    return this.http.delete(`http://localhost:8082/api/v1/cars/${id}`)
  }

  postImage(image : FormData){
    return this.http.post<number>("http://localhost:8082/api/v1/image/upload",image)
  }

  getCarPage() {
    return this.car;
  }

  saveCarPage(car : CarClass){
    this.car = car;
  }

  getImage() {
    return this.images
  }

  saveImage(image : any){
    this.images = image
  }
}
