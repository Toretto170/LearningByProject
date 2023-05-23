var uploadForm = document.getElementById('upload-form');

uploadForm.addEventListener('submit', function(event){
    event.preventDefault();

    var fileInput = document.getElementById('file-input');

    if (fileInput.files.length > 0) {

        var formData = new FormData();

        formData.append('file', fileInput.files[0]);
        
        var xhr = new XMLHttpRequest();

        var url = '/upload' // end point dove funziona l'api, bisogna mettere localhost con porta

        xhr.open('POST', url, true);
        
        xhr.onreadystatechange = function() {
        
            if (xhr.readyState === 4 && xhr.status === 200) {
        
                console.log('File caricato con successo');
        
            }
        };
        
        xhr.send(formData);
    }
});







