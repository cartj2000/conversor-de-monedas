package com.aluracursos.monedas.excepcion;

public class ErrorEnConversorException extends RuntimeException {

    private String mensaje;
    public ErrorEnConversorException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public ErrorEnConversorException(String mensaje) {
        super(mensaje);
    }
}
