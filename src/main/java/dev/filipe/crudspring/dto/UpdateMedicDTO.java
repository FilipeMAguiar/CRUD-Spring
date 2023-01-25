package dev.filipe.crudspring.dto;

import jakarta.validation.constraints.NotNull;


public record UpdateMedicDTO(
        @NotNull
        Long id,
        String telefone,
        String nome,
        EnderecoDTO enderecoDTO) {
}
