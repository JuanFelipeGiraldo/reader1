package Lectorarchivos.Reader.service.readerService;

import Lectorarchivos.Reader.model.CsvInformation;
import Lectorarchivos.Reader.model.TestResult;
import Lectorarchivos.Reader.service.RabbitService.ConsumerRabbitImp;
import Lectorarchivos.Reader.service.RabbitService.PublisherRabbit;
import Lectorarchivos.Reader.service.comunicationSpringBootService.ComunicationServiceImp;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;



@Service
public class CsvReaderService {
    private static Logger logger = LoggerFactory.getLogger(CsvReaderService.class);

    private CountDownLatch latch;
    private int trueAnswer = 0;
    private int falseAnswer = 0;
    private boolean readingResult;
    private TestResult testResult;
    private ComunicationServiceImp comunicationServiceImp;
    private ConsumerRabbitImp consumerRabbitImp;

    private PublisherRabbit publisherRabbit;
    @Autowired
    public CsvReaderService(TestResult testResult, ComunicationServiceImp comunicationServiceImp, ConsumerRabbitImp consumerRabbitImp, PublisherRabbit publisherRabbit) {
        this.testResult = testResult;
        this.comunicationServiceImp = comunicationServiceImp;
        this.consumerRabbitImp = consumerRabbitImp;
        this.publisherRabbit = publisherRabbit;
    }



    public TestResult readCsv(String rutaArchivo ,String tipoLectura) throws FileNotFoundException {
        List<CsvInformation> informationList = new CsvToBeanBuilder(new FileReader(rutaArchivo))
                .withType(CsvInformation.class)
                .build()
                .parse();


        if (tipoLectura.equals("rabbit")) {
            for (CsvInformation object : informationList) {
                Gson gson = new Gson();
                String objeto1 = gson.toJson(object);
                publisherRabbit.send(objeto1);

            }
            System.out.println("se procesa por rabbit");
            waitForMessages();
            testResult.setLineFail(consumerRabbitImp.getFalseAnswer());
            testResult.setLinePass(consumerRabbitImp.getTrueAnswer());
            System.out.println(consumerRabbitImp.getFalseAnswer());
            System.out.println(consumerRabbitImp.getTrueAnswer());
            return testResult;
        }


        if (tipoLectura.equals("spring")) {
            for (CsvInformation object : informationList) {
                readingResult = comunicationServiceImp.read(object);
                if (readingResult == true) {
                    trueAnswer++;
                }
                if (readingResult == false) {
                    falseAnswer++;
                }
            }
            logger.debug("objetos creados:" + trueAnswer);
            logger.debug("objetos fallidos:" + falseAnswer);
            testResult.setLineFail(falseAnswer);
            testResult.setLinePass(trueAnswer);
            this.falseAnswer = 0;
            this.trueAnswer = 0;
            System.out.println("se procesa por spring");
            return testResult;

        }
        return null;
    }

    public void waitForMessages()  {
        latch = new CountDownLatch(1);
        try {
            latch.await(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

