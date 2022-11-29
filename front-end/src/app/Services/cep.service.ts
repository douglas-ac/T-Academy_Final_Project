import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Address } from '../Model/Models';

@Injectable({
  providedIn: 'root'
})
export class CepService {

  constructor(private http: HttpClient) { }

  getCep(cep:number){
    return this.http.get<Address>(`https://viacep.com.br/ws/${cep}/json/`)
  }
}
