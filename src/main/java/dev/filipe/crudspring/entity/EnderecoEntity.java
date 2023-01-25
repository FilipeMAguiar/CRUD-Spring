package dev.filipe.crudspring.entity;

import dev.filipe.crudspring.dto.EnderecoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String UF;
    private String complemento;
    private String numero;

    public EnderecoEntity(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.UF = endereco.UF();
        this.complemento = endereco.complemento();
        this.numero = endereco.numero();
    }

    public void updateInfo(EnderecoDTO data) {
        if (data.logradouro() != null) {
            this.logradouro = data.logradouro();
        }
        if (data.logradouro() != null) {
            this.logradouro = data.logradouro();
        }
        if (data.logradouro() != null) {
            this.logradouro = data.logradouro();
        }
        if (data.bairro() != null) {
            this.bairro = data.bairro();
        }
        if (data.cep() != null) {
            this.cep = data.cep();
        }
        if (data.cidade() != null) {
            this.cidade = data.cidade();
        }
        if (data.UF() != null) {
            this.UF = data.UF();
        }
        if (data.complemento() != null) {
            this.complemento = data.complemento();
        }
        if (data.numero() != null) {
            this.numero = data.numero();
        }
    }
}

