import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/Model/Models';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username !: string
  password !: string

  constructor(private router: Router, private service : UserService) { }

  ngOnInit(): void { }

  navigateToRegisterUser(route: String) {
    this.router.navigate([`${route}`])
  }

  login(){
    this.service.login(this.username, this.password).subscribe(data => console.log(data))
  }
}
