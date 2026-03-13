package pl.l4yoos.github.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.l4yoos.github.models.GithubEvent;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class GitHubService {

    private static final HttpClient client = HttpClient.newHttpClient();

    public static List<GithubEvent> fetch(String username) {
        HttpRequest request = HttpRequest.newBuilder()
                .header("User-agent", "Java-App")
                .uri(URI.create("https://api.github.com/users/" + username + "/events"))
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }

        if (response == null) return Collections.emptyList();

        if (response.statusCode() != 200) {
            handleError(response.statusCode(), username);
            return Collections.emptyList();
        } else {
            ObjectMapper mapper = new ObjectMapper();

            try {
                List<GithubEvent> events = mapper.readValue(response.body(), new TypeReference<>(){});
                if (events != null && events.isEmpty()) {
                    System.out.println("Not Activity.");
                }
                return events;
            } catch (JsonProcessingException e) {
                System.out.println(e.getMessage());
                return Collections.emptyList();
            }
        }
    }

    private static void handleError(int code, String username) {
        switch (code) {
            case 200:
                System.out.println("Not Activity.");
                break;
            case 304:
                System.out.println("Nothing changed.");
                break;
            case 403:
                System.out.println("Permission denied.");
                break;
            case 404:
                System.out.println(username + " not found.");
                break;
            case 503:
                System.out.println("Service unavailable.");
                break;
            default:
                System.out.println("Unknown error: " + code);
                break;
        }
    }
}
