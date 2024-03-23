package Lectorarchivos.Reader.service.comunicationService;

import Lectorarchivos.Reader.model.CsvInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "test",url = "localhost:5050")
public interface ComunicationService {

    @PostMapping("/validator/cvs")
    public boolean read(@RequestBody CsvInformation csvInformation) ;


}

