const fileInput = document.getElementById('fileInput');
const textArea = document.getElementById('testo');
const bottoneAnalisi = document.getElementById('analisi_testo');
const analisiRisultato = document.getElementById('risultato');
const classeImmettiFile = document.getElementsByClassName('immetti-file');
const formRisposta = document.getElementById('form-risposta');



//Eventlistener per attivare la funzione intoTextArea
fileInput.addEventListener('change', intoTextArea);


// Funzione per caricare il file nella textarea
function intoTextArea(){

    const file = fileInput.files[0];
    const reader = new FileReader();
    reader.onload = function(event) {
      var text = event.target.result;
      console.log(text);
      textArea.value = text;
    };

    reader.onerror = function(event) {
      console.error("Errore durante la lettura del file:", event.target.error);
    };

    reader.readAsText(file);

};

// Funzione per gestire la pagina una volta che si clicca Analisi
function modificaPagina(){

  textArea.setAttribute('readonly', true);
  bottoneAnalisi.style.display = "none";
 
  for (var i = 0; i < classeImmettiFile.length; i++) {
    classeImmettiFile[i].style.display = "none";
  }

  formRisposta.innerHTML += "<button type='button' class='btn btn-danger' id='reset-page' onclick='resetPage()'>RESET</button>"

}

//Funzione Reset per riutilizzare la pagina
function resetPage(){

  textArea.removeAttribute('readonly');
  bottoneAnalisi.style.display = "";

  for (var i = 0; i < classeImmettiFile.length; i++) {
    classeImmettiFile[i].style.display = "";
  }

  textArea.value = "";
  document.getElementById('reset-page').remove();
  document.getElementById('risultato').remove();
  document.getElementById('contenitore-risposta').innerHTML += "<div id='risultato' class='bg-light'></div>"
  //formRisposta.style.display = "none";


}


// Connessione ad API via POST
function postFile() {
  
  var text = textArea.value;
  return new Promise(function(resolve, reject) {
    const URLPOST = 'http://localhost:9020/api/process';
    let request = new XMLHttpRequest();

    request.open('POST', URLPOST);
    request.setRequestHeader('Content-Type', 'text/plain');

    request.onload = function() {
      if (request.status === 200) {
        console.log("Il file è stato caricato correttamente.");
        resolve();
      } else {
        console.error("Il file non è stato caricato. La richiesta non è andata a buon fine. Codice Errore:", request.statusText);
        reject(new Error(request.statusText));
      }
    };

    request.onerror = function() {
      console.error('Il file non è stato caricato. La richiesta non è riuscita ad essere inviata');
      reject(new Error('Errore di connessione'));
    };

    request.send(text);
  });
}

// Connessione ad API via GET
function getFile() {
  formRisposta.removeAttribute('style');
  return fetch('http://localhost:9020/api/analisi')
    .then(function(response) {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error("Errore durante la richiesta");
      }
    })
    .then(function(data) {
      data.forEach(function(item) {
        var listItem = document.createElement("li");
        listItem.textContent = item;
        analisiRisultato.appendChild(listItem);
      });
    })
    .catch(function(error) {
      console.error(error);
    });
}

// Connessione ad API via DELETE
function deleteFile() {
  return new Promise(function(resolve, reject) {
    const URLDELETE = 'http://localhost:9020/api/svuota';
    let request = new XMLHttpRequest();

    request.open('DELETE', URLDELETE);
    request.setRequestHeader('Content-Type', 'application/json');

    request.onload = function() {
      if (request.status === 200) {
        console.log("Il file è stato eliminato correttamente.");
        resolve();
      } else {
        console.error("Il file non è stato eliminato. La richiesta non è andata a buon fine. Codice Errore:", request.statusText);
        reject(new Error(request.statusText));
      }
    };

    request.onerror = function() {
      console.error('Il file non è stato eliminato. La richiesta non è riuscita ad essere inviata');
      reject(new Error('Errore di connessione'));
    };

    request.send();
  });
}

// Fa tutte e tre le cose e gestisce la modale di errore
function callAPI() {

  if(textArea.value.replace(/\s+/g, "") == "") {
    console.error("Errore: nessun testo da analizzare");
    textArea.value = "";
    $('#myModal').modal('show');}

  else {
  
  postFile()
    .then(function() {
      return getFile();
    })
    .then(function() {
      modificaPagina();
      return deleteFile();
    })
    .then(function() {
      console.log("Tutte le operazioni sono state completate con successo.");
    })
    .catch(function(error) {
      console.error("Si è verificato un errore durante l'esecuzione delle operazioni:", error);
    });
  }
}
