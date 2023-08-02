package com.relacionamentos.javadb.api.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteResponse {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
}
