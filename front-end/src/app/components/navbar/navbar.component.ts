import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  open:boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  openCart(){
    this.open = true;
    console.log(this.open);
  }

  receiveFeedback(){
    this.open=false;
    console.log(this.open);
  }

}
