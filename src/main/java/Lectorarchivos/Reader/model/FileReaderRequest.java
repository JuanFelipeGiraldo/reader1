package Lectorarchivos.Reader.model;

import Lectorarchivos.Reader.service.readerService.FileReaderService;

public class FileReaderRequest {
    private String ruta;
    private String tipoArchivo;
    private String tipoLectura;

    public FileReaderRequest(String ruta, String tipoArchivo, String tipoLectura) {
        this.ruta = ruta;
        this.tipoArchivo = tipoArchivo;
        this.tipoLectura = tipoLectura;
    }
    public String getTipoLectura() {
        return tipoLectura;
    }
    public String getRuta() {
        return ruta;
    }
    public String getTipoArchivo() {
        return tipoArchivo;
    }
}
