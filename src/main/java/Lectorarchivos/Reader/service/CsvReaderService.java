package Lectorarchivos.Reader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class CsvReaderService {

    private BufferedReader lector;

    private String linea;

    private String partes[] = null ;

    public CsvReaderService() {
    }

    public void readCsv(String rutaArchivo){

        try {
            lector = new BufferedReader(new FileReader(rutaArchivo));
            while ((linea=lector.readLine())!= null){
                partes= linea.split(",");
                imprimir();
                System.out.println();


            }
            lector.close();
            linea= null;
            partes= null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void imprimir(){
        for (int i = 0; i < partes.length; i++) {
            System.out.print(partes[i]+"  ,  ");
        }
    }
}

