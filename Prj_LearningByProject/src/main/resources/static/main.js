function processFile() {
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
    }