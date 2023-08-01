package com.relacionamentos.javadb.api.controller;


import com.relacionamentos.javadb.domain.entity.Paciente;
import com.relacionamentos.javadb.domain.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable Integer id){

        Optional<Paciente> paciente = pacienteService.getById(id);

        if(paciente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(paciente.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update (@PathVariable Integer id, @RequestBody Paciente paciente){

        Paciente pacienteBombaPatch = pacienteService.update(id, paciente);

        return ResponseEntity.status(HttpStatus.OK).body(pacienteBombaPatch);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        pacienteService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
