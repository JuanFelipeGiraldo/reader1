package Lectorarchivos.Reader.service;

import Lectorarchivos.Reader.model.ContenidoExcel;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class XlsxReaderService {
    public ContenidoExcel procesarArchivoExcel(String ruta) throws IOException {
        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(ruta)))) {
            // Procesa el archivo Excel aquí y devuelve el contenido
            ContenidoExcel contenido = new ContenidoExcel();
            // Lógica para leer y procesar el archivo Excel
            return contenido;
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new IOException("Error al procesar el archivo Excel", e);
        }

    }
}
