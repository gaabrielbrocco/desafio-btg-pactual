package desafio.btg_pactual.controller.dto;

import desafio.btg_pactual.entity.OrderEntity;

import java.math.BigDecimal;

// Representa a resposta de um pedido específico na API
public record OrderResponse(Long orderId,
                            Long customerId,
                            BigDecimal total) {

    // converter uma entidade OrderEntity em OrderResponse
    public static OrderResponse fromEntity(OrderEntity entity) {
        return new OrderResponse(entity.getOrderId(), entity.getCustomerId(), entity.getTotal());
    }
}
