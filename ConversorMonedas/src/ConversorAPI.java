import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorAPI {

    private static final String API_KEY = "4280bcadc8ebf9ddab82ad0a";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/"+ API_KEY +"/latest/USD";

    public static double obtenerTipoCambio(String moneda){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpURLConnection.HTTP_OK) {
                JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
                JsonObject rates =jsonObject.getAsJsonObject("conversion_rates");

                if (rates != null && rates.has(moneda)){
                    return rates.get(moneda).getAsDouble();
                } else {
                    System.out.println("La moneda solicitada no está disponible.");
                }
            } else {
                System.out.println("Error en la solicitud: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al consumir la API: " + e.getMessage());
        }
        return 0.0;
    }




}