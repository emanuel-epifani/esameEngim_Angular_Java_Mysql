import { Component, OnInit } from '@angular/core';
import { TariffaCorriere } from 'src/app/models/tariffa-corriere';

@Component({
  selector: 'app-tariffe',
  templateUrl: './tariffe.component.html',
  styleUrls: ['./tariffe.component.scss']
})
export class TariffeComponent implements OnInit {
  tariffe: TariffaCorriere[] = [];
  missingData: boolean = true;

  constructor() { }

  ngOnInit(): void {
    this.getUArticlesFromServer();
  }

  getUArticlesFromServer() {
    fetch('http://localhost:8090/tariffe')
      .then((response)=>{
        if(response.status<205){ return response.json() }
        throw Error(response.statusText)
      })
      .then((data)=>{
        console.log(data)
        this.tariffe = data;
      })
      .catch((error)=>{
        console.log('Errore ', error)
      })
  }


  addNewRate(
    nomeCorriere: string,
    nomeTariffa: string,
    pesoMax: number,
    costo: number
    ) {
      console.log(nomeCorriere, nomeTariffa, pesoMax, costo);

      let rate: TariffaCorriere = {
      id: this.tariffe.length+1,
      nome_corriere: nomeCorriere.trim(),
      nome_tariffa: nomeTariffa.trim(),
      peso_max: pesoMax,
      costo: costo,
    }
    if(rate.nome_corriere != "" && rate.nome_tariffa != "" && rate.peso_max > 0 && rate.costo > 0) {

      this.missingData = false;
      this.tariffe.push(rate);
      console.log(rate);
      //console.log(this.tariffe);

    } else {
      this.missingData = true;
      alert("Dievi riempire tuti i campi per poter salvare")

    }

  }

  deleteOneRate(item: TariffaCorriere) {
    const indexToRemove = this.tariffe.indexOf(item);
    this.tariffe.splice(indexToRemove, 1);
  }



}
