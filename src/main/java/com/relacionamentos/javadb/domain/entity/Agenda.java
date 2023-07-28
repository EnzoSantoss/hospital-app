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
@Table(name = "agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private LocalDate updateAt;
    private  LocalDate deletedAt;

    @ManyToOne
    private Paciente paciente;

    //Update constructor
    public Agenda(String descricao, LocalDate updateAt) {
        this.descricao = descricao;
        this.updateAt = updateAt;
    }

    //Delete Constructor
    public Agenda(String descricao, LocalDate updateAt, LocalDate deletedAt) {
        this.descricao = descricao;
        this.updateAt = updateAt;
        this.deletedAt = deletedAt;
    }
}
