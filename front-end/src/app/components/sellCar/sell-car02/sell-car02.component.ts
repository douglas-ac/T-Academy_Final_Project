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

  years : number[] = []

  categorys : string[] = ["Hatch", "Sedan", "SUV", "Cupê", "Pick-up", "Conversivel", "Minivan", "Van" , "Station Wagon", "Outro"]

  car : CarClass = new CarClass();

  automakers : String[] = [] 
  
  constructor(private service : CarService, private router : Router) { }

  ngOnInit( ): void {
    this.service.getAutomakers().subscribe(data => {
      this.automakers = data
    })
    for(let i=1920 ; i<= 2023 ; i++){
      this.years.push(i)
    }
    this.years = this.years.reverse()
  }

  continue(){
    console.log(this.car.automaker)
    console.log(this.car.model)
    console.log(this.car.color)
    console.log(this.car.year)
    this.service.saveCarPage(this.car)
    this.router.navigate(['sell-car03'])
  }
}
