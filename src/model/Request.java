package model;

import com.google.gson.Gson;
import record.APICover;
import record.APIValue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Request {
    private final String key;

    public Request(String key) {
        this.key = key;
    }

    public ArrayList<Code> cods() {
        String rota = "/codes";

        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + this.key + rota))
                .build();

        try {
            HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

            APIValue apiValue = gson.fromJson(response.body(), APIValue.class);

            ArrayList<Code> apiCode = new ArrayList<>();

            for (List<String> codeData : apiValue.supported_codes()) {
                String code = codeData.get(0);
                String name = codeData.get(1);
                apiCode.add(new Code(code, name));
            }

            return apiCode;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double cover(String origin, String objective, double value) {
        String rota = "/pair/" + origin + "/" + objective + "/" + value;

        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + this.key + rota))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            APICover apiCover = gson.fromJson(response.body(), APICover.class);

            return apiCover.conversion_result();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
