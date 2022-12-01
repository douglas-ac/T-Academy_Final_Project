import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarService } from 'src/app/Services/car.service';

@Component({
  selector: 'app-sell-car05',
  templateUrl: './sell-car05.component.html',
  styleUrls: ['./sell-car05.component.css']
})
export class SellCar05Component implements OnInit {

  constructor(private service : CarService,private router : Router) { }

  ngOnInit(): void {
  }

  continue(){
    const form : any = document.getElementById("form");
    const inputFile : any = document.getElementById("file");

    const formData = new FormData();
    
    for (const file of inputFile.files) {
      formData.append("image", file);
      
    } 

    this.service.saveImage(formData)

    this.router.navigate(['sell-car06'])
  }

}
