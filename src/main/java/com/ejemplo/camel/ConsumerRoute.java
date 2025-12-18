package com.ejemplo.camel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRoute extends RouteBuilder {
    @Override
public void configure() throws Exception {
    from("rabbitmq:test.camel.exchange"
        + "?hostname=localhost"
        + "&username=guest&password=guest"
        + "&queue=test.camel.queue" // <-- AQUÍ especificamos tu cola manual
        + "&routingKey=test.camel.queue"
        + "&autoDelete=false")
        .log("RECIBIDO DESDE RABBITMQ: ${body}");
}
}