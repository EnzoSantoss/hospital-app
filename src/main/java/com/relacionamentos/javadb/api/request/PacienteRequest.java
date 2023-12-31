package com.relacionamentos.javadb.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteRequest {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
}
