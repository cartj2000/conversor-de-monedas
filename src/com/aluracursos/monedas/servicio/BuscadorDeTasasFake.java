package com.aluracursos.monedas.servicio;

import static java.lang.Math.random;

public class BuscadorDeTasasFake implements BuscadorDeTasas {

    @Override
    public double obtenerConversion(String origen, String destino, double cantidad) {

//        double valor = Math.random() * 1000;
        double valor = 2000;
        if(origen == "USD" && destino == "ARS") {valor=1400;}
        if(origen == "ARS" && destino == "USD") {valor=0.0007;}
        if(origen == "USD" && destino == "BRL") {valor=5;}
        if(origen == "BRL" && destino == "USD") {valor=0.2;}
        if(origen == "USD" && destino == "COP") {valor=3800;}
        if(origen == "COP" && destino == "USD") {valor=0.0003;}

        return cantidad * valor; // Ensayo
    }
}