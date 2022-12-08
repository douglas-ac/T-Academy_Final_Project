import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router : Router, private authService : AuthService) { }

  ngOnInit(): void {
  }

  naviBar(route : string){
    this.router.navigate([`${route}`])
  }

  isLogged() : boolean{
    return sessionStorage.getItem('token') ? true : false
  }

  logOut(){
    sessionStorage.removeItem('token')
    sessionStorage.removeItem('idUser')
    this.naviBar('')
  }

}
