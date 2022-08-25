package root.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("rabbit")
@RequiredArgsConstructor
public class MessageSenderServiceRabbit implements  MessageSender{

    private final RabbitTemplate rabbitTemplate;
    @Override
    public void send(String message) {
        rabbitTemplate.convertAndSend("myQueue", message);
    }
}
