import { Component, OnInit } from '@angular/core';
import { Articolo } from 'src/app/models/articolo';

@Component({
  selector: 'app-articoli',
  templateUrl: './articoli.component.html',
  styleUrls: ['./articoli.component.scss']
})
export class ArticoliComponent implements OnInit {
  articles: Articolo[] = [];
  missingData: boolean = true;


  constructor() { }

  ngOnInit(): void {
    this.getUArticlesFromServer();
  }

  getUArticlesFromServer() {
    fetch('http://localhost:8090/articoli')
      .then((response)=>{
        if(response.status<205){ return response.json() }
        throw Error(response.statusText)
      })
      .then((data)=>{
        console.log(data)
        this.articles = data;
      })
      .catch((error)=>{
        console.log('Errore ', error)
      })
  }

/*   addNewUser(
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

  } */

}
