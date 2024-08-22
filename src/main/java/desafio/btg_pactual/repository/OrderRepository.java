package desafio.btg_pactual.repository;

import desafio.btg_pactual.controller.dto.OrderResponse;
import desafio.btg_pactual.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

// Interface que estende MongoRepository para fornecer métodos CRUD para a entidade OrderEntity
public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
    // Retorna uma página de pedidos filtrados pelo customerId
    Page<OrderEntity> findAllByCustomerId(Long customerId, PageRequest pageRequest);
}
