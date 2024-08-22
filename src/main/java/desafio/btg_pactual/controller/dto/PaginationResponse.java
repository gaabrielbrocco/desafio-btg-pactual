package desafio.btg_pactual.controller.dto;

import org.springframework.data.domain.Page;

// Representa as informações de paginação na resposta da API
public record PaginationResponse(Integer page,
                                 Integer pageSize,
                                 Long totalElements,
                                 Integer totalPages) {


    // Método estático que cria um PaginationResponse a partir de um objeto Page
    public static PaginationResponse fromPage(Page<?> page) {
        return new PaginationResponse(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}
