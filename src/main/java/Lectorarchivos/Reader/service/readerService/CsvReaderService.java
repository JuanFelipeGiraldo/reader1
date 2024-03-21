package Lectorarchivos.Reader.service.readerService;

import Lectorarchivos.Reader.model.CsvInformation;
import Lectorarchivos.Reader.model.TestResult;
import Lectorarchivos.Reader.service.comunicationService.ComunicationServiceImp;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class CsvReaderService {
    private int pass = 0;
    private int fail = 0;
    private TestResult testResult;
    private ComunicationServiceImp comunicationServiceImp;
    @Autowired
    public CsvReaderService(TestResult testResult, ComunicationServiceImp comunicationServiceImp) {
        this.testResult = testResult;
        this.comunicationServiceImp = comunicationServiceImp;
    }
    public TestResult readCsv(String rutaArchivo) throws FileNotFoundException {
        System.out.println("entro el archivo a crearse");

        List<CsvInformation> informationList = new CsvToBeanBuilder(new FileReader(rutaArchivo))
                .withType(CsvInformation.class)
                .build()
                .parse();
        informationList.forEach(System.out::println);

        for (CsvInformation object : informationList) {
            boolean x = comunicationServiceImp.read(object);
            if (x == true) {
                pass++;
            } else if (x==false){
                fail++;
            }
        }
        System.out.println("objetos creados:" + pass);
        System.out.println("objetos fallidos:" + fail);
        testResult.setObjectFail(fail);
        testResult.setObjectPass(pass);
        this.fail=0;
        this.pass=0;
        return testResult;

    }

}

