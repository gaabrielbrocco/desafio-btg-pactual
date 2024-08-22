package desafio.btg_pactual.listener.dto;

import java.util.List;


// Representa o evento de criação de pedido, usado quando uma mensagem é recebida via RabbitMQ.
public record OrderCreatedEvent(Long codigoPedido,
                                Long codigoCliente,
                                List<OrderItemEvent> itens) {
}
