package root.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@Slf4j
@RestController
@RequiredArgsConstructor
@Profile("http")
public class MessageController {
    @PostMapping("/message")
    public void sendMessage(@RequestBody @NotEmpty String message) {
        log.info("message controller Consumer get a message {}" , message);
    }
}
