package desafio.btg_pactual.listener.dto;

import java.math.BigDecimal;


// Representa um item do pedido dentro do evento de criação
public record OrderItemEvent(String produto,
                             Integer quantidade,
                             BigDecimal preco) {
}
