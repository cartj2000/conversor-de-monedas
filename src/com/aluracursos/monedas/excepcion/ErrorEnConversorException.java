package com.aluracursos.monedas.excepcion;

public class ErrorEnConversorException extends RuntimeException {

    public ErrorEnConversorException(String mensaje) {
        super(mensaje);
    }

    public ErrorEnConversorException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
