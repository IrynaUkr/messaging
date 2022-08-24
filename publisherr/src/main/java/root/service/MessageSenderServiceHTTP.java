package root.service;

import root.client.ConsumerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("http")
@RequiredArgsConstructor
public class MessageSenderServiceHTTP implements MessageSender {
    private final ConsumerClient consumerClient;
    @Override
    public void send(String message){
        consumerClient.send(message);
    }
}

