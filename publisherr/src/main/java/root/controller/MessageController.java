package root.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import root.service.MessageSenderServiceHTTP;

import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageSenderServiceHTTP messageSenderService;
    @PostMapping("/message")
    public void sendMessageToPublisher(@RequestBody @NotEmpty String message){
        messageSenderService.send(message);
    }
}
