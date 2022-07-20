/*
Eseguire una request in GET all indirizzo : https://reqres.in/api/users
Con la lista di user ottenuti dalla request creare una tabella e inserirla nella pagina
Le intestazioni della tablla sono Nome, Cognome, ed Email
Decidere quali proprietà negli oggetti ottenuti dalla request 
corrispondono a Nome, Cognome, ed Email ed usarli per creare le righe della tabella.
*/

fetch('https://reqres.in/api/users')
.then((response)=>{
// Qui Posso esaminare:
// - Stato della risposta
// - Metadati (ES: headers)
return response.json()
})
.then((data)=>{
    console.log(data);
    console.log(data['data']);
   


    let table = document.createElement('table');
    let rigaHeader = document.createElement('tr');
  
    //riempo la prima riga
    let col1 = document.createElement('th');
    col1.innerText = 'Nome';
    rigaHeader.append(col1);

    let col2 = document.createElement('th');
    col2.innerText = 'Cognome';
    rigaHeader.append(col2);

    let col3 = document.createElement('th');
    col3.innerText = 'Email';
    rigaHeader.append(col3);
      
    table.append(rigaHeader);
    
    //per ogni Users (data['data'])
    for (const index of data['data']) {
        //creo una RIGA 
        let righeBody = document.createElement('tr');
        righeBody.id= index['id']; //creo l'id diverso per ogni riga


        //creo prima cella
        let td1 = document.createElement('td');
        td1.innerText= [index['first_name']];
        righeBody.append(td1);

        //creo seconda cella
        let td2 = document.createElement('td');
        td2.innerText= [index['last_name']];
        righeBody.append(td2);

        //creo terza cella
        let td3 = document.createElement('td');
        td3.innerText= [index['email']];
        righeBody.append(td3);
        
        //creo quarta cella con bottone Elimina
        let td4 = document.createElement('td');
        td4.innerHTML = '<button>Elimina riga</button>';
            //ci appendo un aEventListener
            td4.addEventListener('click', function(event) {
                localStorage.setItem(righeBody.id,righeBody.id);//aggiungo al local storage elementi eliminati
                righeBody.remove();
            })
        


        //appendo le celle dentro la rigaBody
        righeBody.append(td4);
        //e appendo tutte le righe Body alla table
        if (righeBody.id != localStorage[righeBody.id]) {
            //qui credo andrebbe "table.append(righeBody);" e poi altro che devo ancora pensare come risolvere
        }
        table.append(righeBody);     

    }
    

    //appendo la PRIMA riga
    document.body.append(table);
})