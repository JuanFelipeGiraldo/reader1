package Lectorarchivos.Reader.service.readerService;

import Lectorarchivos.Reader.model.CsvInformation;
import Lectorarchivos.Reader.model.TestResult;
import Lectorarchivos.Reader.service.comunicationService.ComunicationServiceImp;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import org.slf4j.Logger;



@Service
public class CsvReaderService {
    private static Logger logger = LoggerFactory.getLogger(CsvReaderService.class);
    private int trueAnswer = 0;
    private int falseAnswer = 0;
    private boolean readingResult;
    private TestResult testResult;
    private ComunicationServiceImp comunicationServiceImp;
    @Autowired
    public CsvReaderService(TestResult testResult, ComunicationServiceImp comunicationServiceImp) {
        this.testResult = testResult;
        this.comunicationServiceImp = comunicationServiceImp;
    }
    public TestResult readCsv(String rutaArchivo) throws FileNotFoundException {
        List<CsvInformation> informationList = new CsvToBeanBuilder(new FileReader(rutaArchivo))
                .withType(CsvInformation.class)
                .build()
                .parse();

        for (CsvInformation object : informationList) {
            readingResult = comunicationServiceImp.read(object);
            if (readingResult == true) {
                trueAnswer++;
            }
            if (readingResult==false){
                falseAnswer++;
            }
        }
        logger.debug("objetos creados:" + trueAnswer);
        logger.debug("objetos fallidos:" + falseAnswer);
        testResult.setLineFail(falseAnswer);
        testResult.setLinePass(trueAnswer);
        this.falseAnswer =0;
        this.trueAnswer =0;
        return testResult;

    }
}

