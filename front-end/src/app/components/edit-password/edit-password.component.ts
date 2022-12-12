import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-edit-password',
  templateUrl: './edit-password.component.html',
  styleUrls: ['./edit-password.component.css']
})
export class EditPasswordComponent {
  
  sent: boolean = false;
  userId = sessionStorage.getItem('idUser') || ''
  id = Number(this.userId)

  constructor(private userService: UserService){ }

  passwordHolder = new FormGroup({
    oldPassword : new FormControl('', [Validators.required]),
    password: new FormControl('', [
      Validators.required,
      Validators.pattern(
        '^(?=.*[A-Z])(?=.*[!#@$%&])(?=.*[0-9])(?=.*[a-z]).{6,15}$'
      ),
    ]),
    confirmPassword: new FormControl('', [Validators.required])
  });

  changePassword(){
    this.sent = true;

    if(this.passwordHolder.value.confirmPassword != this.passwordHolder.value.password){
      alert("Senhas diferentes")
      return
    } 

    this.userService.changePassword(this.id , 
                                    this.passwordHolder.value.oldPassword || '', 
                                    this.passwordHolder.value.password || '' )
                                    .subscribe( data => console.log(data))
  }
}
