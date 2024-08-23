package desafio.btg_pactual.controller.dto;

import java.util.List;
import java.util.Map;

// padronização contendo dados e informações de paginação.
public record ApiResponse<T>(Map<String, Object> summary,
                             List<T> data,
                             PaginationResponse pagination) {
}
