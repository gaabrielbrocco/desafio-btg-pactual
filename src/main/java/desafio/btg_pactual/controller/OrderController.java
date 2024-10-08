package desafio.btg_pactual.controller;

import desafio.btg_pactual.controller.dto.ApiResponse;
import desafio.btg_pactual.controller.dto.OrderResponse;
import desafio.btg_pactual.controller.dto.PaginationResponse;
import desafio.btg_pactual.controller.dto.SummaryResponse;
import desafio.btg_pactual.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderController {

        // Serviço que contém a lógica de negócios relacionada aos pedidos.
    @Autowired
    private OrderService orderService;

//        public OrderController(OrderService orderService) {
//            this.orderService = orderService;
//        }

        @GetMapping("/customers/{customerId}/orders")
        // Lista paginada de pedidos do cliente, incluindo informações de paginação.
        public ResponseEntity<ApiResponse<OrderResponse>> listOrders(@PathVariable("customerId")Long customerId,
                                                                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

            var pageResponse = orderService.findAllByCustomerId(customerId, PageRequest.of(page, pageSize));
            var totalOnOrders = orderService.findTotalOrdersByCustomerId(customerId);

            return ResponseEntity.ok(new ApiResponse<>(
                    Map.of("totalOnOrders", totalOnOrders),
                    pageResponse.getContent(),
                    PaginationResponse.fromPage(pageResponse)
            ));
        }

        @GetMapping("/customers/{customerId}/orders/summary")

        public ResponseEntity<SummaryResponse> listSummary(@PathVariable("customerId") Long customerId) {
            var summary = orderService.findTotalOrdersByCustomerId(customerId);

            return ResponseEntity.ok(new SummaryResponse(Map.of("totalOnOrders", summary)));

        }

    }
