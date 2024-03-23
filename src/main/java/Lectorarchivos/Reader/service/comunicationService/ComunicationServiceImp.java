package Lectorarchivos.Reader.service.comunicationService;

import Lectorarchivos.Reader.model.CsvInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class ComunicationServiceImp {
    ComunicationService comunicationService;
    @Autowired
    public ComunicationServiceImp(ComunicationService comunicationService) {
        this.comunicationService = comunicationService;
    }
    public boolean read(CsvInformation csvInformation) {
        return comunicationService.read(csvInformation);
    }




}
