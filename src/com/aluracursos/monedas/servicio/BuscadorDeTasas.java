package com.aluracursos.monedas.servicio;

// interfaz definiendo el contrato para obtener la conversión de moneda
// desacoplando la lógica del negocio (Conversor) de la implementación real o fake
public interface BuscadorDeTasas {
    // retorna la conversión de la cantidad de la moneda origen a la destino
    double obtenerConversion(String origen, String destino, double cantidad);
}

