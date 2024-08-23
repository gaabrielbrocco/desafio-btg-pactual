package desafio.btg_pactual.listener;

import desafio.btg_pactual.listener.dto.OrderCreatedEvent;
import desafio.btg_pactual.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static desafio.btg_pactual.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Component
// Componente que escuta eventos de criação de pedidos recebidos via RabbitMQ
public class OrderCreateListener {

    private final Logger logger = LoggerFactory.getLogger(OrderCreateListener.class);

    // Serviço responsável por salvar o pedido no banco de dados
    @Autowired
    private OrderService orderService;

//    public OrderCreateListener(OrderService orderService) {
//        this.orderService = orderService;
//    }

    // Método que é acionado ao receber uma mensagem na fila ORDER_CREATED_QUEUE
    //  Ele extrai a informação do evento e delega a criação do pedido ao OrderService
    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void listen(OrderCreatedEvent message) {
        logger.info("Message consumed: {}", message);

        orderService.save(message);
    }
}