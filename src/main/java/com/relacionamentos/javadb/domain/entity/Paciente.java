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
    private LocalDate updateAt;
    private  LocalDate deletedAt;

    //Update constructor
    public Paciente(String nome, String sobrenome, String cpf, String email, LocalDate updateAt) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.updateAt = updateAt;
    }

    //Delete constructor
    public Paciente(String nome, String sobrenome, String cpf, String email, LocalDate updateAt, LocalDate deletedAt) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.updateAt = updateAt;
        this.deletedAt = deletedAt;
    }
}
