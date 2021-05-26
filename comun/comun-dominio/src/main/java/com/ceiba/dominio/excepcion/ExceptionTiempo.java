package com.ceiba.dominio.excepcion;

public class ExceptionTiempo extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExceptionTiempo(String mensaje){
        super(mensaje);
    }
}
