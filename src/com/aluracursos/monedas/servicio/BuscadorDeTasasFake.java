package com.aluracursos.monedas.servicio;

import static java.lang.Math.random;

public class BuscadorDeTasasFake implements BuscadorDeTasas {

    @Override
    public double obtenerConversion(String origen, String destino, double cantidad) {
        double valor = Math.random() * 1000;
        return cantidad * valor; // Ensayo
    }
}