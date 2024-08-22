package desafio.btg_pactual.controller;

import desafio.btg_pactual.controller.dto.ApiResponse;
import desafio.btg_pactual.controller.dto.OrderResponse;
import desafio.btg_pactual.controller.dto.PaginationResponse;
import desafio.btg_pactual.service.OrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    @RestController
public class OrderController {

        // Serviço que contém a lógica de negócios relacionada aos pedidos.
    private final OrderService orderService;

        public OrderController(OrderService orderService) {
            this.orderService = orderService;
        }

        @GetMapping("/customers/{customerId}/orders")
        // Lista paginada de pedidos do cliente, incluindo informações de paginação.
        public ResponseEntity<ApiResponse<OrderResponse>> listOrders(@PathVariable("customerId")Long customerId,
                                                                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

            var pageResponse = orderService.findAllByCustomerId(customerId, PageRequest.of(page, pageSize));

            return ResponseEntity.ok(new ApiResponse<>(
                    pageResponse.getContent(),
                    PaginationResponse.fromPage(pageResponse)
            ));
        }
    }
