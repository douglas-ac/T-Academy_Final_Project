import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { User, Address, Login } from 'src/app/Model/Models';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  sent: boolean = false

  constructor(private service: UserService, private formBuilder: FormBuilder) {}
  
  register = new FormGroup ({
    fullname: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.pattern('^(?=.*[A-Z])(?=.*[!#@$%&])(?=.*[0-9])(?=.*[a-z]).{6,15}$')]),
    confirmPassword: new FormControl('', [Validators.required]),
    cpf: new FormControl('', [Validators.required, Validators.pattern('[0-9]{3}\.?[0-9]{3}\.?[0-9]{3}\-?[0-9]{2}')]),
    birthDate: new FormControl('', [Validators.required]),
    cellphone: new FormControl('', [Validators.required]),
    zipCode: new FormControl('', [Validators.required]),
    street: new FormControl('', [Validators.required]),
    addressNumber: new FormControl('', [Validators.required]),
    city: new FormControl('', [Validators.required]),
    state: new FormControl('', [Validators.required]),
    neighborhood: new FormControl('', [Validators.required]),
    addressComplement: new FormControl()
  })

  convertBirthDate() {
    let date = new Date(this.register.value.birthDate || '');
    let dateFormated = (date.getUTCDate()) + "-" + (date.getUTCMonth() + 1) + "-" + (date.getUTCFullYear())

    return dateFormated
  }
  
  registerUser(): void {   
    this.sent = true
     
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

    address.cep = this.register.value.zipCode || ''
    address.logradouro = this.register.value.street || ''
    address.complemento = this.register.value.addressNumber || ''
    address.bairro = this.register.value.neighborhood || ''
    address.localidade = this.register.value.city || ''
    address.uf = this.register.value.state || ''

    login.username = this.register.value.email || ''
    login.password = this.register.value.password || ''

    user.name = this.register.value.fullname || ''
    user.email = this.register.value.email || ''
    user.birthDate = this.convertBirthDate()
    user.login = login;
    user.nacionalNumber = this.register.value.cpf || ''
    user.fone = this.register.value.cellphone || ''
    user.adress = address;
    user.descriminationColumn = "cpf";

    console.log(user)

    this.service.post(user)
    .subscribe(() => {})
  }
  
}
