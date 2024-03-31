package Lectorarchivos.Reader.controller;
import Lectorarchivos.Reader.model.FileReaderRequest;
import Lectorarchivos.Reader.model.TestResult;
import Lectorarchivos.Reader.service.readerService.FileReaderService;
import Lectorarchivos.Reader.service.comunicationSpringBootService.ComunicationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
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
       return fileReaderService.read(request);
    }

}

