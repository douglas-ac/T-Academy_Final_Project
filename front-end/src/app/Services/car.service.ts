import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Car, CarClass, Images } from '../Model/Models';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  car : CarClass = new CarClass();
  images : any 

  constructor(private http: HttpClient ) { }

  getAll() {
    return this.http.get<[Car]>("http://localhost:8082/api/v1/cars")
  }

  getOne(id:number){
    return this.http.get<[Car]>(`http://localhost:8082/api/v1/cars/${id}`)
  }

  getAutomakers() {
    return this.http.get<String[]>("http://localhost:8082/api/v1/cars/automakers")
  }

  post(data: Car){
    return this.http.post<Car>("http://localhost:8082/api/v1/cars",data)
  }

  put(id:number, data:Car){
    return this.http.put<[Car]>(`http://localhost:8082/api/v1/cars/${id}`, data)
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
