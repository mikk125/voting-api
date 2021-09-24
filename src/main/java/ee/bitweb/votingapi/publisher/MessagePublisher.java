package ee.bitweb.votingapi.publisher;

import ee.bitweb.votingapi.config.MQConfig;
import ee.bitweb.votingapi.model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/vote")
    public Message publishMessage(@RequestBody Message message) {
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        return message;
    }
}
