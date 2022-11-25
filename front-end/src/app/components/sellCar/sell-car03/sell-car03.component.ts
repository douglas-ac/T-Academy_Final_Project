import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarClass } from 'src/app/Model/Models';
import { CarService } from 'src/app/Services/car.service';

@Component({
  selector: 'app-sell-car03',
  templateUrl: './sell-car03.component.html',
  styleUrls: ['./sell-car03.component.css']
})
export class SellCar03Component implements OnInit {

  car : CarClass = new CarClass();

  constructor(private service : CarService, private router : Router) { }

  ngOnInit(): void {
    this.car = this.service.getCarPage();
  }

  continue(){
    this.service.saveCarPage(this.car)
    this.router.navigate(['sell-car06'])
  }

}
