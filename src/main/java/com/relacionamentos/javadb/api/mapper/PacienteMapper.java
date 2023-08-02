package com.relacionamentos.javadb.api.mapper;

import com.relacionamentos.javadb.api.request.PacienteRequest;
import com.relacionamentos.javadb.api.response.PacienteResponse;
import com.relacionamentos.javadb.domain.entity.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteMapper {

    public static Paciente toPaciente(PacienteRequest pacienteRequest){

        Paciente paciente = new Paciente();

        paciente.setNome(pacienteRequest.getNome());
        paciente.setSobrenome(pacienteRequest.getSobrenome());
        paciente.setCpf(pacienteRequest.getCpf());
        paciente.setEmail(pacienteRequest.getEmail());

        return paciente;
    }

    public static PacienteResponse toPacienteResponse (Paciente pacienteEntity){
        PacienteResponse pacienteResponse = new PacienteResponse();

        pacienteResponse.setId(pacienteEntity.getId());
        pacienteResponse.setNome(pacienteEntity.getNome());
        pacienteResponse.setSobrenome(pacienteEntity.getSobrenome());
        pacienteResponse.setCpf(pacienteEntity.getCpf());
        pacienteResponse.setEmail(pacienteEntity.getEmail());

        return  pacienteResponse;
    }

    public static List<PacienteResponse> toPacienteResponseList(List<Paciente> pacienteList){

        //return pacienteList.stream().map(this::toPacienteResponse).collect(Collectors.toList());

        List<PacienteResponse> responseList = new ArrayList<>();

        for(Paciente paciente : pacienteList){
            PacienteResponse pacienteResponse = toPacienteResponse(paciente);
            responseList.add(pacienteResponse);
        }

        return responseList;
    }
}
