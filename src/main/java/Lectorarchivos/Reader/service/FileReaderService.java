package Lectorarchivos.Reader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLOutput;

@Service
public class FileReaderService {
   //@Autowired


    private String ruta;
    private String tipoArchivo;



    public void read(FileReaderService fileReaderService) throws IOException {

        if (fileReaderService.getTipoArchivo().equals("csv")){
            CsvReaderService csvReaderService = new CsvReaderService();
            csvReaderService.readCsv(fileReaderService.ruta);
            System.out.println("Procesando datos csv");

        }
        if (fileReaderService.getTipoArchivo().equals("xlsx")) {
            XlsxReaderService xlsxReaderService = new XlsxReaderService();
            try {
                xlsxReaderService.procesarArchivoExcel(fileReaderService.getRuta());
                System.out.println("Procesando datos xlsx");
            } catch (IOException e) {
                System.err.println("Error al procesar el archivo Excel: " + e.getMessage());
            }
        }
    }

    public String getRuta() {
        return ruta;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }
}
