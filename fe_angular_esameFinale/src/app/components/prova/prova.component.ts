import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-prova',
  templateUrl: './prova.component.html',
  styleUrls: ['./prova.component.scss']
})
export class ProvaComponent implements OnInit {

  constructor() { }

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
      })
      .catch((error)=>{
        console.log('Errore ', error)
      })
  }
  

}
