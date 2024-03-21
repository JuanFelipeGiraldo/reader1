package Lectorarchivos.Reader.model;

import Lectorarchivos.Reader.service.readerService.FileReaderService;

public class FileReaderRequest {
    private String ruta;
    private String tipoArchivo;

    public FileReaderRequest(String ruta, String tipoArchivo) {
        this.ruta = ruta;
        this.tipoArchivo = tipoArchivo;
    }

    public String getRuta() {
        return ruta;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }
}
