    package com.relacionamentos.javadb.domain.service;

    import com.relacionamentos.javadb.domain.entity.Paciente;
    import com.relacionamentos.javadb.domain.repository.PacienteRepository;
    import com.relacionamentos.javadb.exception.BusinessExcepition;
    import jakarta.persistence.EntityNotFoundException;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.List;
    import java.util.Optional;

    @Service
    @Transactional
    @RequiredArgsConstructor
    public class PacienteService {

        private final PacienteRepository pacienteRepository;
        public Paciente save(Paciente paciente){

            Optional<Paciente> existePaciente = pacienteRepository.buscarPorCpf(paciente.getCpf());

            if(existePaciente.isPresent()){
                throw new BusinessExcepition("CPF ja cadastrado");
            }else{
                return pacienteRepository.save(paciente);
            }

        }

        public List<Paciente> getAll(){

            return  pacienteRepository.findAll();
        }

        public Optional<Paciente> getById(Integer id){
            return pacienteRepository.findById(id);
        }

        public Paciente update(Integer id, Paciente paciente){

            Optional<Paciente> toUpdate = pacienteRepository.findById(id);

            if (toUpdate.isPresent()) {

                Paciente pacienteToUpdate = toUpdate.get();
                pacienteToUpdate.setUpdate_At(LocalDateTime.now());

                toUpdate.get().setNome(paciente.getNome());
                return pacienteRepository.save(pacienteToUpdate);

            } else {
                // Tratar o cenário em que o paciente não foi encontrado pelo ID.
                throw new EntityNotFoundException("Paciente não encontrado com o ID: " + id);
            }

        }

        public void delete(Integer id){
            Paciente pacienteToDelete = pacienteRepository.findById(id).orElse(null);

            if(pacienteToDelete == null){
                throw new RuntimeException("Paciente não existe");
            }

            pacienteToDelete.setDeleted_at(LocalDate.now());

            pacienteRepository.save(pacienteToDelete);

        }

    }
