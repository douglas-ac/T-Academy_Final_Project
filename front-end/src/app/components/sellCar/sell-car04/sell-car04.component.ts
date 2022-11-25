import { Component, OnInit } from '@angular/core';
import { CarClass } from 'src/app/Model/Models';

@Component({
  selector: 'app-sell-car04',
  templateUrl: './sell-car04.component.html',
  styleUrls: ['./sell-car04.component.css']
})
export class SellCar04Component implements OnInit {

  car : CarClass = new CarClass();

  constructor() { }

  ngOnInit(): void {
  }

}
