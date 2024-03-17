package Lectorarchivos.Reader.controller;

import Lectorarchivos.Reader.service.FileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ReaderController {
    @Autowired
    FileReaderService fileReaderService;

    @PostMapping("/reader")
    public ResponseEntity read(@RequestBody FileReaderService fileReaderService) throws IOException {
        System.out.println("se recibio archivo ");
        fileReaderService.read(fileReaderService);
        return ResponseEntity.ok("se recibio archivo de tipo "+fileReaderService.getTipoArchivo());
    }

        @GetMapping("/")
        public String test(){
            return "llego";
        }
}

