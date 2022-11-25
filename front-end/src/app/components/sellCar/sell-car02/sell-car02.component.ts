import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarClass } from 'src/app/Model/Models';
import { CarService } from 'src/app/Services/car.service';

@Component({
  selector: 'app-sell-car02',
  templateUrl: './sell-car02.component.html',
  styleUrls: ['./sell-car02.component.css']
})
export class SellCar02Component implements OnInit {

  car : CarClass = new CarClass();
  
  constructor(private service : CarService, private router : Router) { }

  ngOnInit(): void {}

  continue(){
    this.service.saveCarPage(this.car)
    this.router.navigate(['sell-car03'])
  }
}
