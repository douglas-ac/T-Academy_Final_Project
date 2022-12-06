import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate{

  token ?: string

  constructor(private router: Router) { }
  
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let token = sessionStorage.getItem('token') || '' 
    if(token == ''){
      this.router.navigate(['login'])
    }
    return true
  }

  getToken(){
    return sessionStorage.getItem('token')
  }

  getId(){
    return sessionStorage.getItem('idUser')
  }
}
