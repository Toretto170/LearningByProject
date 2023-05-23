function handleFormSubmit(event) {
    event.preventDefault();
  
    const file = fileInput.files[0];
  
    if (file) {
      const formData = new FormData();
      formData.append('file', file);
  
      fetch('/upload', {
        method: 'POST',
        body: formData,
      })
        .then((response) => {
          if (response.ok) {
            return response.text();
          } else {
            throw new Error('Errore durante il caricamento del file');
          }
        })
        .then((responseText) => {
          console.log(responseText); // Esegui azioni con la risposta del server
        })
        .catch((error) => {
          console.error(error); // Gestisci eventuali errori
        });
    }
  }
  
  const form = document.getElementById('upload-form');
  form.addEventListener('submit', handleFormSubmit);
  