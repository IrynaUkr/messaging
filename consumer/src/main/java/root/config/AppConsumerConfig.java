package root.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;




@Configuration
@Profile("rabbit")
public class AppConsumerConfig {
    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", false);
    }

}