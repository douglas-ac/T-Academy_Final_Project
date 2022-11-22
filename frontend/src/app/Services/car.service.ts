import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Car } from '../Model/Models';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<[Car]>("http://localhost:8082/api/v1/cars")
  }

  getOne(id:number){
    return this.http.get<[Car]>(`http://localhost:8082/api/v1/cars/${id}`)
  }

  post(data: Car){
    return this.http.post<Car>("http://localhost:8082/api/v1/cars",data)
  }

  put(id:number, data:Car){
    return this.http.put<[Car]>(`http://localhost:8082/api/v1/cars/${id}`, data)
  }
}
