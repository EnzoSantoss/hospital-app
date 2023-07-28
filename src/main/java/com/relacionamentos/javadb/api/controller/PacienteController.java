package com.relacionamentos.javadb.api.controller;


import com.relacionamentos.javadb.domain.entity.Paciente;
import com.relacionamentos.javadb.domain.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<Paciente> create (@RequestBody Paciente paciente){

        System.out.println(paciente);
        Paciente createPaciente = pacienteService.save(paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(createPaciente);
    }

    @GetMapping()
    public ResponseEntity<List<Paciente>> getAll(){

        List<Paciente> getAllPacientes = pacienteService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(getAllPacientes);

    }

}
