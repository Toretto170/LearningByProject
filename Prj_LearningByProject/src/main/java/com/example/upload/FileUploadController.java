package com.example.upload;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.repos.FraseDAO;
import com.example.repos.ParolaDAO;

@Controller
public class FileUploadController {

    @Autowired
    private ParolaDAO parolaRepo;
    
    @Autowired
    private FraseDAO fraseRepo;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] fileBytes = file.getBytes();
                String fileContent = new String(fileBytes);
                
                //logica di stefano per scomporre testo in frasi e parole
                /*
                 * // Utilizza Scanner per suddividere il contenuto in parole e frasi
                Scanner scanner = new Scanner(fileContent);
                
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    String sentence = scanner.nextLine().trim();
                    
                    Parola parola = new Parola();
                    parola.setParola(word);
                    parolaRepo.save(parola);
                    
                    Frase frase = new Frase();
                    frase.setFrase(sentence);
                    fraseRepo.save(frase);
                }
                
                scanner.close();
                 * */
                
                return ResponseEntity.status(HttpStatus.OK).body("File caricato con successo");
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante il caricamento del file");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nessun file caricato");
        }
    }
}
