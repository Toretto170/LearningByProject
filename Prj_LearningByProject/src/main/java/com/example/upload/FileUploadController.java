package com.example.upload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUploadController {

    @Value("/repofilesalvati")
    private String fileUploadPath;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Ottieni il nome del file originale
                String originalFilename = file.getOriginalFilename();

                // Crea il percorso completo in cui salvare il file
                String filePath = fileUploadPath + File.separator + originalFilename;

                // Crea un oggetto File dal percorso
                File destFile = new File(filePath);

                // Salva il file nella posizione specificata
                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(destFile));

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
