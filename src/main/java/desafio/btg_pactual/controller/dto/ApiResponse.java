package desafio.btg_pactual.controller.dto;

import java.util.List;

// padronização contendo dados e informações de paginação.
public record ApiResponse<T>(List<T> data, PaginationResponse pagination) {
}
