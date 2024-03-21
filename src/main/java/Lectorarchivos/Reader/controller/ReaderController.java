package Lectorarchivos.Reader.controller;
import Lectorarchivos.Reader.model.CsvInformation;
import Lectorarchivos.Reader.model.FileReaderRequest;
import Lectorarchivos.Reader.model.TestResult;
import Lectorarchivos.Reader.service.readerService.FileReaderService;
import Lectorarchivos.Reader.service.comunicationService.ComunicationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ReaderController {

    @Autowired
    private ComunicationServiceImp comunicationServiceImp;
    @Autowired
    private FileReaderService fileReaderService;

    @PostMapping("/reader")
    public TestResult read(@RequestBody FileReaderRequest request) throws IOException {
        System.out.println("se recibio archivo ");
       return fileReaderService.read(request);//lectura local
    }

    @GetMapping("/reader")
    public String test() {
        return "Reader ON";
    }

    @GetMapping("/reader/texto2")
    public String test2() {
        String s = comunicationServiceImp.testearServicios();
        System.out.println(s);
        return s;
    }

    @PostMapping("/usuarios/test/cvs")
    public boolean test3(@RequestBody CsvInformation csvInformation) {
        System.out.println(comunicationServiceImp.read(csvInformation));
        return comunicationServiceImp.read(csvInformation);

    }

}

