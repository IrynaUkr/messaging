package root.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component
@Profile("http")
@RequiredArgsConstructor
public class ConsumerClient {

    private static final String CONSUMER_URL = "http://localhost:8082";
    private static final String CONSUMER_PATH = "/message";
    private static final String POST_REQUEST_ERROR = "Error occurred while post request";
    private final  HttpClient httpClient;
    public void send(String message){
       String url = CONSUMER_URL + CONSUMER_PATH;
       HttpRequest httpRequest;

        try {
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .POST(HttpRequest.BodyPublishers.ofString(url))
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode()== HttpStatus.OK.value()){
                log.info("consumer responded with status ok");
            }
            else{
                log.info("consumer responded with status {}: {}",response.statusCode(), response.body());
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
