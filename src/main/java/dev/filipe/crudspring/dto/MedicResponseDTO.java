package dev.filipe.crudspring.dto;

import dev.filipe.crudspring.entity.MedicEntity;

public record MedicResponseDTO(String nome, String email, String crm, EspecialidadeEnum especialidadeEnum, Long id) {

    public MedicResponseDTO(MedicEntity medicEntity){
        this(medicEntity.getNome(), medicEntity.getEmail(), medicEntity.getCrm(), medicEntity.getEspecialidade(), medicEntity.getId());
    }
}
