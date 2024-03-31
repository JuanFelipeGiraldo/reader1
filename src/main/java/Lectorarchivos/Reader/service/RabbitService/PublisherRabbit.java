package Lectorarchivos.Reader.service.RabbitService;

import Lectorarchivos.Reader.model.CsvInformation;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@EnableRabbit
public class PublisherRabbit {
    private RabbitTemplate rabbitTemplate;
    @Autowired
    public PublisherRabbit(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void send(String csvInformation){
        rabbitTemplate.convertAndSend("csvperson",csvInformation);
    }
}
