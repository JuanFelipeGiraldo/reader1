package Lectorarchivos.Reader.service.RabbitService;

import org.springframework.messaging.handler.annotation.Payload;

public interface Consumer {

    void recive(@Payload String jsoninfo);
}
