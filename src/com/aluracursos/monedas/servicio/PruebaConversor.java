package com.aluracursos.monedas.servicio;

import com.aluracursos.monedas.logica.Conversor;

import java.io.FileWriter;
import java.io.IOException;

public class PruebaConversor {

    public PruebaConversor() {
    }

    public void ejecutarPrueba() {

        Conversor conversorTest = new Conversor(new BuscadorDeTasasFake());
        double primerTest = conversorTest.convertir("USD", "COP", 100);
        double segundoTest = conversorTest.convertir("USD", "BRL", 500);

        assert primerTest == 380000 : "USD A COP FALLÓ";
        assert segundoTest == 2500 : "USD A BRL FALLÓ";

        FileWriter escritura;

        try {
            escritura = new FileWriter("prueba.txt",true);
            escritura.write("\nEl resultado de la primera prueba es: " + String.format("%,.5f", primerTest));
            escritura.write("\nEl resultado de la segunda prueba es: " + String.format("%,.5f", segundoTest));
            escritura.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
