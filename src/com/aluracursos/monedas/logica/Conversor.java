package com.aluracursos.monedas.logica;

import com.aluracursos.monedas.servicio.BuscadorDeTasas;

// lógica del negocio
public class Conversor {

    private final BuscadorDeTasas buscador; // se aplica inmutabilidad

    // Dependencia obligatoria: firma del constructor clara (parámetros: número + tipo + orden)
    // se crea el constructor con inyección de dependencia
    // buscador se usa para implementar el servicio de búsqueda tanto real como fake
    public Conversor(BuscadorDeTasas buscador) {
        this.buscador = buscador;
    }

    // conversión validando que la cantidad no sea negativa a través de
    // throw IllegalArgumentException
    public double convertir(String origen, String destino, double cantidad) {
        // se valida la entrada con respecto a la lógica del negocio
        if (origen == null || destino == null || origen.isBlank() || destino.isBlank()) {
            throw new IllegalArgumentException("Las monedas origen/destino no pueden ser nulas ni vacías");
        }

        if (cantidad < 0) {
            throw new IllegalArgumentException("Valor a convertir negativo -> debe ser positivo !");
        }
        return buscador.obtenerConversion(origen, destino, cantidad);
    }
}

