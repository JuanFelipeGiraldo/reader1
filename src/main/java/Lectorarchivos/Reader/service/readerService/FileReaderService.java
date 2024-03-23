package Lectorarchivos.Reader.service.readerService;

import Lectorarchivos.Reader.model.FileReaderRequest;
import Lectorarchivos.Reader.model.TestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FileReaderService {
    private CsvReaderService csvReaderService;
    @Autowired
    public FileReaderService(CsvReaderService csvReaderService) {
        this.csvReaderService = csvReaderService;
    }
    public TestResult read(FileReaderRequest fileReaderRequest) throws IOException {
        if (fileReaderRequest.getTipoArchivo().equals("csv")) {
            try {
                return csvReaderService.readCsv(fileReaderRequest.getRuta());
            } catch (IOException e) {
                System.out.println("Error al procesar archivo CSV" + e.getMessage());
            }
        }
        return null;
    }
}