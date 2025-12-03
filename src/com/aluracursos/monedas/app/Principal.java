package com.aluracursos.monedas.app;

import com.aluracursos.monedas.excepcion.ErrorEnConversorException;
import com.aluracursos.monedas.logica.Conversor;
import com.aluracursos.monedas.servicio.BuscadorDeTasasDelJson;
import com.aluracursos.monedas.servicio.PruebaBuscadorDeTasas;
import com.aluracursos.monedas.servicio.BuscadorDeTasasFake;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String apiKey = "06a762746f8fe41ad81c76a9";
        String origen;
        String destino;

        // Inyección de dependencia:
        // Al crear la instancia conversor pasándo la implementación real
        // del buscador de tasas
        // BuscadorDeTasas servicio = new BuscadorDeTasasDelJson(apiKey);
        // Conversor conversor = new Conversor(servicio);
        Conversor conversor = new Conversor(new BuscadorDeTasasDelJson(apiKey));

        // Inyección de dependencia:
        // Al crear la instancia prueba pasándo la implementación fake
        // del buscador de tasas
        // BuscadorDeTasas buscador = new BuscadorDeTasasFake();
        // PruebaBuscadorDeTasas prueba = new PruebaBuscadorDeTasas(buscador);
        PruebaBuscadorDeTasas prueba = new PruebaBuscadorDeTasas(new BuscadorDeTasasFake());
        prueba.ejecutarPrueba();

        System.out.println("Conversor de Moneda -> Inicio ...");
        int opcion = 0;
        while (opcion != 7) {
            try {
                MostrarMenu();
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                }

                if (opcion == 7) break;

                switch (opcion) {
                    case 1 -> { origen = "USD"; destino = "ARS"; manejarConversion(conversor,scanner,origen,destino);}
                    case 2 -> { origen = "ARS"; destino = "USD"; manejarConversion(conversor,scanner,origen,destino);}
                    case 3 -> { origen = "USD"; destino = "BRL"; manejarConversion(conversor,scanner,origen,destino);}
                    case 4 -> { origen = "BRL"; destino = "USD"; manejarConversion(conversor,scanner,origen,destino);}
                    case 5 -> { origen = "USD"; destino = "COP"; manejarConversion(conversor,scanner,origen,destino);}
                    case 6 -> { origen = "COP"; destino = "USD"; manejarConversion(conversor,scanner,origen,destino);}
                    default -> {
                        System.out.println("Opción inválida.");
                        scanner.nextLine();
                    }
                }
            } catch (ErrorEnConversorException e) {         // manejo de la excepción
                                                            // personalizada
                System.out.println("Error en el proceso de conversión: " + e.getMessage());
                if (e.getCause() != null) {                 // si hay causa se muestra
                    System.err.println("Causa origen: " + e.getCause().getMessage());
                }
            } catch (Exception e) {                         // para otro error
                                                            // inesperado
                System.err.println("\nERROR INESPERADO: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Programa finalizado");
    }

    private static void MostrarMenu() {
        System.out.println("***********************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real Brasileño");
        System.out.println("4) Real Brasileño => Dólar");
        System.out.println("5) Dólar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Salir");
        System.out.println("Elija una opción válida:");
        System.out.println("***********************************************");
    }

    private static void manejarConversion(Conversor conversor, Scanner scanner, String origen, String destino) {
        System.out.printf("Ingrese la cantidad a convertir de %s a %s: ", origen, destino);
        try {
            if (!scanner.hasNextDouble()) {
                scanner.nextLine();                             // se valida la cantidad digitada
                throw new InputMismatchException("La cantidad a convertir no es un número válido");
            }
            double cantidad = scanner.nextDouble();
            scanner.nextLine();
            double resultado = conversor.convertir(origen, destino, cantidad); // se llama la lógica del negocio
            System.out.println("Resultado: " + String.format("%,.2f", resultado) + " " + destino);
        } catch (InputMismatchException e) {
            System.out.println("\n Error en la entrada de la cantidad: " + e.getMessage());
        } catch (IllegalArgumentException e) {  // se captura la validación
                                                // de cantidad negativa
                                                // de la clase Conversor
            System.out.println("Error de validación: " + e.getMessage());
        } catch (ErrorEnConversorException e) { // se lanza la excepción
                                                // para que sea capturada
                                                // y manejada en el bucle
                                                // principal (main)
            throw e;
        } catch (Exception e) {
            System.err.println("\n Error inesperado en la conversión: " + e.getMessage());
        }
    }

}