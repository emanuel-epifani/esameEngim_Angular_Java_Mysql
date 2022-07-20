import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-prova',
  templateUrl: './prova.component.html',
  styleUrls: ['./prova.component.scss']
})
export class ProvaComponent implements OnInit {
  users: User[] = [];
  missingData: boolean = true;

  constructor(
  /*     private formBuilder: FormBuilder*/  
  ) { }

  ngOnInit(): void {
    this.getUserFromRequest();

  }
  


  getUserFromRequest() {
    fetch('https://reqres.in/api/users')
      .then((response)=>{
        if(response.status<205){ return response.json() }
        throw Error(response.statusText)
      })
      .then((data)=>{
        console.log(data)
        console.log(data['data'])
        this.users = data['data'];
        console.log("users");
        console.log(this.users);
      })
      .catch((error)=>{
        console.log('Errore ', error)
      })
  }

  addNewUser(
    email: string,
    firstName: string,
    last_name: string,
    avatar: string
    ) {

      let user: User = {
      id: this.users.length+1,
      email: email.trim(),
      first_name: firstName.trim(),
      last_name: last_name.trim(),
      avatar: avatar.trim(),
    }
    if(user.email != "" && user.first_name != "" && user.last_name != "" && user.avatar != "") {
      this.missingData = false;
      this.users.push(user);
      console.log(this.users);
    } else {
      alert("Dievi riempire tuti i campi per poter salvare")
      this.missingData = true;
    }

  }
  

}
