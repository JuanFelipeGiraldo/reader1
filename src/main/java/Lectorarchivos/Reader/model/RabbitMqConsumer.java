package Lectorarchivos.Reader.model;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RabbitMqConsumer {

    private ObjectMapper objectMapper;

    public RabbitMqConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
