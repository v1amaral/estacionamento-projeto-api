package br.com.parking.util;

import br.com.parking.exception.CepInvalidoException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ApiCEP {

    public String buscarPorCep(String cep) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("viacep.com.br/ws/" + cep + "/json/"))
                .timeout(Duration.ofSeconds(10))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar CEP: " + e.getMessage());
        }
    }
}

