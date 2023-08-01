package com.relacionamentos.javadb.domain.repository;

import com.relacionamentos.javadb.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    @Query("from Paciente p where p.cpf = :cpf")
    Optional<Paciente> buscarPorCpf(String cpf);
}
