package com.aluracursos.monedas.servicio;

import java.io.FileWriter;
import java.io.IOException;

public class PruebaBuscadorDeTasas {

    private final BuscadorDeTasas buscador;

    //aplicamos inyección directa

    public PruebaBuscadorDeTasas(BuscadorDeTasas buscador) {
        this.buscador = buscador;
    }

    public void ejecutarPrueba() {

        double resultado = buscador.obtenerConversion("USD", "COP", 10000);

        FileWriter escritura;

        try {
            escritura = new FileWriter("prueba.txt",true);
            escritura.write("El resultado de la prueba es: " + resultado);
            escritura.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
