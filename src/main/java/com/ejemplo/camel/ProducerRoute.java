package com.ejemplo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProducerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:generate?period=5000")
            .setBody().simple("Mensaje generado en ${date:now:yyyy-MM-dd HH:mm:ss}")
            .log("Enviando: ${body}")
            .to("rabbitmq:test.camel.exchange"
                + "?hostname=localhost"
                + "&username=guest&password=guest"
                + "&exchangeType=direct"
                + "&routingKey=test.camel.queue"
                + "&declare=true"
                + "&durable=true"
                + "&autoDelete=false");
    }
}