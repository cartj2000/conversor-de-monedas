package com.aluracursos.monedas.servicio;

import com.aluracursos.monedas.excepcion.ErrorEnConversorException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscadorDeTasasDelJson implements BuscadorDeTasas {

    private final String apiKey;

    public BuscadorDeTasasDelJson(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public double obtenerConversion(String origen, String destino, double cantidad) {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + origen + "/" + destino + "/" + cantidad;

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            if (respuesta.statusCode() != 200)
                throw new ErrorEnConversorException("Error HTTP " + respuesta.statusCode());

            JsonObject json = JsonParser.parseString(respuesta.body()).getAsJsonObject();

            if (json == null)
                throw new ErrorEnConversorException("JSON inválido");

            if (!json.has("conversion_result"))
                throw new ErrorEnConversorException("API sin campo conversion_result.");

            JsonElement conversion = json.get("conversion_result");

            if (conversion == null || conversion.isJsonNull()) {
                throw new ErrorEnConversorException("respuesta JSON no contiene conversion_result");
            } else {
                return conversion.getAsDouble();
            }

        } catch (IOException e) {               // error de red
            throw new ErrorEnConversorException("Error de red: " + e.getMessage());
        } catch (InterruptedException e) {      // hilo interrumpido
            Thread.currentThread().interrupt();
            throw new ErrorEnConversorException("Búsqueda interrumpida");
        } catch (Exception e) {
            throw new ErrorEnConversorException("Error al obtener las tasas: " + e.getMessage());
        }
    }
}

