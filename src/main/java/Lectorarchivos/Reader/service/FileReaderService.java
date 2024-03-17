package Lectorarchivos.Reader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileReaderService {

    CsvReaderService csvReaderService;

    private String ruta;
    private String tipoArchivo;



    public FileReaderService(String ruta, String tipoArchivo) {
        this.ruta = ruta;
        this.tipoArchivo = tipoArchivo;
    }

    public void read(FileReaderService fileReaderService){
        if (fileReaderService.getTipoArchivo()=="csv"){
            csvReaderService.readCsv(fileReaderService.ruta);
            System.out.println("se recibio archivo csv");
        }

    }

    public String getRuta() {
        return ruta;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }
}

