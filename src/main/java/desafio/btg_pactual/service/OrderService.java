package desafio.btg_pactual.service;

import desafio.btg_pactual.controller.dto.OrderResponse;
import desafio.btg_pactual.entity.OrderEntity;
import desafio.btg_pactual.entity.OrderItem;
import desafio.btg_pactual.listener.dto.OrderCreatedEvent;
import desafio.btg_pactual.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Salva um pedido no banco de dados a partir de um OrderCreatedEvent
    public void save(OrderCreatedEvent event) {

        // ORDER -> ENTITY

        var entity = new OrderEntity();
        entity.setOrderId(event.codigoPedido());
        entity.setCustomerId(event.codigoCliente());
        entity.setItems(getOrderItems(event));
        entity.setTotal(getTotal(event));

        orderRepository.save(entity);
    }

    // Busca todos os pedidos de um cliente de forma paginada.
    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest) {
        var orders = orderRepository.findAllByCustomerId(customerId, pageRequest);

        return orders.map(OrderResponse::fromEntity);
    }

    // Calcula o total do pedido somando o preço multiplicado pela quantidade de cada item.
    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens().stream().map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    // Converte a lista de OrderItemEvent em OrderItem.
    private static List<OrderItem> getOrderItems(OrderCreatedEvent event) {
        return event.itens().stream().map(i -> new OrderItem(i.produto(), i.quantidade(), i.preco())).toList();
    }


}








