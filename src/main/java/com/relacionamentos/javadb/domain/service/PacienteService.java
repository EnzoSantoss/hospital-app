    package com.relacionamentos.javadb.domain.service;

    import com.relacionamentos.javadb.domain.entity.Paciente;
    import com.relacionamentos.javadb.domain.repository.PacienteRepository;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import java.time.LocalDate;
    import java.util.List;
    import java.util.Optional;

    @Service
    @Transactional
    @RequiredArgsConstructor
    public class PacienteService {

        private final PacienteRepository pacienteRepository;
        public Paciente save(Paciente paciente){

            //TODO: adiconar validações para não cadastrar cpf ou emails iguais

            return pacienteRepository.save(paciente);
        }

        public List<Paciente> getAll(){

            return  pacienteRepository.findAll();
        }

        public Optional<Paciente> getById(Integer id){
            return pacienteRepository.findById(id);
        }

    //    public Paciente update(){}
    //
        public Paciente delete(Integer id){
            Paciente pacienteToDelete = pacienteRepository.findById(id).orElse(null);

            if(pacienteToDelete == null){
                throw new RuntimeException("Paciente não existe");
            }


            pacienteToDelete.setDeleted_at(LocalDate.now());

            return pacienteRepository.save(pacienteToDelete);
        }


    }
