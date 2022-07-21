import { Component, OnInit } from '@angular/core';
import { Ordine } from 'src/app/models/ordine';

@Component({
  selector: 'app-ordini',
  templateUrl: './ordini.component.html',
  styleUrls: ['./ordini.component.scss']
})
export class OrdiniComponent implements OnInit {
  ordini: Ordine[] = [];

  constructor() { }

  ngOnInit(): void {
    this.getOrdersFromServer();
  }


  getOrdersFromServer() {
    fetch('http://localhost:8090/ordinConPreventivo')
      .then((response)=>{
        if(response.status<205){ return response.json() }
        throw Error(response.statusText)
      })
      .then((data)=>{
        console.log(data)
        this.ordini = data;
        console.log("this.ordini");
      })
      .catch((error)=>{
        console.log('Errore ', error)
      })
  }

}
