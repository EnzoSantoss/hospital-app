package com.relacionamentos.javadb.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime update_At;
    private  LocalDate deleted_at;


//    //Create Constructor
//    public Paciente(String nome, String sobrenome, String cpf, String email) {
//        this.nome = nome;
//        this.sobrenome = sobrenome;
//        this.cpf = cpf;
//        this.email = email;
//    }

    //Update constructor
    public Paciente(String nome, String sobrenome, String cpf, String email, LocalDateTime update_At) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.update_At = update_At;
    }

    //Delete constructor
    public Paciente(String nome, String sobrenome, String cpf, String email, LocalDateTime updateAt, LocalDate deleted_at) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.update_At = updateAt;
        this.deleted_at = deleted_at;
    }
}
