
//HU style

const table = document.getElementById('fermate');
const url = 'http://localhost:8081/fermate';

fetch(url)
    .then((response) => {
        return response.json();
    })
    .then((data) => {
        let fermate = data;
        
        //x ogni fermata
        fermate.map(function(fermata) {
            //creo una riga
            let tr = document.createElement('tr');
            //creo le cella
            let id = document.createElement('td');
            let nome = document.createElement('td');
            let zona = document.createElement('td');

            id.innerHTML = `${fermata.id}`;
            nome.innerHTML = `${fermata.nome}`;
            zona.innerHTML = `${fermata.zona}`;

            tr.appendChild(id);
            tr.appendChild(nome);
            tr.appendChild(zona);
            table.appendChild(tr);
        });
    })
    .catch(function(error) {
        console.log(error);
    });
