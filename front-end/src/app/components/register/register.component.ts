import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { User, Address, Login } from 'src/app/Model/Models';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  constructor(private service: UserService) {}

  register = new FormGroup({
    fullname: new FormControl(),
    email: new FormControl(),
    password: new FormControl(),
    confirmPassword: new FormControl(),
    cpf: new FormControl(),
    birthDate: new FormControl(),
    cellphone: new FormControl(),
    zipCode: new FormControl(),
    street: new FormControl(),
    addressNumber: new FormControl(),
    city: new FormControl(),
    state: new FormControl(),
    neighborhood: new FormControl(),
    addressComplement: new FormControl()
  })

  convertBirthDate() {
    let date = new Date(this.register.value.birthDate);
    let dateFormated = (date.getUTCDate()) + "-" + (date.getUTCMonth() + 1) + "-" + (date.getUTCFullYear())

    return dateFormated
  }
  
  registerUser(): void {
    let address: Address  = {
      cep: "",
      localidade: "",
      uf: ""
    }

    let user: User = {
      id: 0,
      name: "",
      email: "",
      fone: ""
    }

    let login: Login = {
      username: "",
      password: ""
    }

    address.cep = this.register.value.zipCode
    address.logradouro = this.register.value.street
    address.complemento = this.register.value.addressNumber
    address.bairro = this.register.value.neighborhood
    address.localidade = this.register.value.city
    address.uf = this.register.value.state

    login.username = this.register.value.email
    login.password = this.register.value.password

    user.name = this.register.value.fullname
    user.email = this.register.value.email
    user.birthDate = this.convertBirthDate()
    user.login = login;
    user.nacionalNumber = this.register.value.cpf
    user.fone = this.register.value.cellphone
    user.adress = address;
    user.descriminationColumn = "cpf";

    console.log(user)

    this.service.post(user)
    .subscribe(() => {})
  }
  
}
