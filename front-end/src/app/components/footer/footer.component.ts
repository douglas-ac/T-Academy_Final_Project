import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {


  isLogged() : boolean{
    return sessionStorage.getItem('token') ? true : false
  }
}
