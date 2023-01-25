package dev.filipe.crudspring.entity;

import dev.filipe.crudspring.dto.EnderecoDTO;
import dev.filipe.crudspring.dto.EspecialidadeEnum;
import dev.filipe.crudspring.dto.MedicDTO;
import dev.filipe.crudspring.dto.UpdateMedicDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    private String telefone;

    private String crm;

    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    @Embedded
    private EnderecoEntity endereco;

    public MedicEntity(MedicDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new EnderecoEntity(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(UpdateMedicDTO dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.enderecoDTO() != null) {
            this.endereco.updateInfo(dados.enderecoDTO());
        }

    }

    public void delete() {
        this.ativo = false;
    }
}
