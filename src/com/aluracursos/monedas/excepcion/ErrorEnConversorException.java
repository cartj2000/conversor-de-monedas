package com.aluracursos.monedas.excepcion;

public class ErrorEnConversorException extends RuntimeException {

    private String mensaje;
    public ErrorEnConversorException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }

}
