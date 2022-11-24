import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  register = new FormGroup({
    fullname: new FormControl(),
    email: new FormControl(),
    password: new FormControl(),
    confirmPassword: new FormControl(),
    cpf: new FormControl(),
    dateBirth: new FormControl(),
    cellphone: new FormControl(),
    zipCode: new FormControl(),
    street: new FormControl(),
    addressNumber: new FormControl(),
    city: new FormControl(),
    neighboor: new FormControl(),
    addressComplement: new FormControl()
  })
  
}
