function processFile() {
      
      /////Chiamata all'api POST
      const fileInput = document.getElementById('fileInput');
      const file = fileInput.files[0];

      const reader = new FileReader();
      reader.onload = function(e) {
        const text = e.target.result;

        const url = 'http://localhost:9020/api/process';

        const xhr = new XMLHttpRequest();
        xhr.open('POST', url);
        xhr.setRequestHeader('Content-Type', 'text/plain');
        xhr.onload = function() {
          if (xhr.status === 200) {
            console.log('Risposta:', xhr.responseText);

          } else {
            console.error('Errore:', xhr.status);
          }
        };
        xhr.onerror = function() {
          console.error('Errore di rete');
        };
        xhr.send(text);
      };
     
      reader.readAsText(file);

};

function getAnalisi() {
  //Scarica le analisi:
  const urlget = 'http://localhost:9020/api/analisi'
  fetch(urlget)
  .then(function(response) {
    if (response.ok) {
      return response.json();
    } else {
      throw new Error("Errore durante la richiesta");
    }
  })
  .then(function(data) {
    var dataList = document.getElementById("analisi_testo");
    data.forEach(function(item) {
      var listItem = document.createElement("li");
      listItem.textContent = item;
      dataList.appendChild(listItem);
    });
  })
  .catch(function(error) {
    console.error(error);
  });
};

function svuotaTabelle() {
  
  const urldelete = 'http://localhost:9020/api/svuota'
  fetch(urldelete, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json',
      // Altri header se necessari
    },
    body: JSON.stringify({
      // Dati da inviare nel corpo della richiesta, se necessari
    })
  })
    .then(response => {
      if (response.ok) {
        // Gestisci la risposta del server in caso di successo
        console.log('Eliminazione effettuata con successo!');
      } else {
        // Gestisci la risposta del server in caso di errore
        console.log('Si è verificato un errore durante l\'eliminazione.');
      }
    })
    .catch(error => {
      // Gestisci eventuali errori di connessione o eccezioni
      console.log('Si è verificato un errore:', error);
    });
  
};

