package com.aluracursos.monedas.servicio;

import static java.lang.Math.random;

public class BuscadorDeTasasFake implements BuscadorDeTasas {

    @Override
    public double obtenerConversion(String origen, String destino, double cantidad) {

//        double valor = Math.random() * 1000;
        double valor = 2000;
        if(origen.equals("USD") && destino.equals("ARS")) {valor=1400;}
        if(origen.equals("ARS") && destino.equals("USD")) {valor=0.0007;}
        if(origen.equals("USD") && destino.equals("BRL")) {valor=5;}
        if(origen.equals("BRL") && destino.equals("USD")) {valor=0.2;}
        if(origen.equals("USD") && destino.equals("COP")) {valor=3800;}
        if(origen.equals("COP") && destino.equals("USD")) {valor=0.0003;}

        return cantidad * valor; // Ensayo
    }
}