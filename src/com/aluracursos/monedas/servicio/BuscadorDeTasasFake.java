package com.aluracursos.monedas.servicio;

public class BuscadorDeTasasFake implements BuscadorDeTasas {

    @Override
    public double obtenerConversion(String origen, String destino, double cantidad) {
        return cantidad * 500; // Ensayo
    }
}