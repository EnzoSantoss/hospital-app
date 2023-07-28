package com.relacionamentos.javadb.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private LocalDate update_At;
    private  LocalDate deleted_at;

    //Update constructor
    public Paciente(String nome, String sobrenome, String cpf, String email, LocalDate update_At) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.update_At = update_At;
    }

    //Delete constructor
    public Paciente(String nome, String sobrenome, String cpf, String email, LocalDate updateAt, LocalDate deleted_at) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.update_At = updateAt;
        this.deleted_at = deleted_at;
    }
}
