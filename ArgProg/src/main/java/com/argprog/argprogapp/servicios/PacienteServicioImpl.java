package com.argprog.argprogapp.servicios;

import com.argprog.argprogapp.entidades.Paciente;
import com.argprog.argprogapp.repositorios.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio{

    private final PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente traerById(Long id) {
        return pacienteRepository.findById(id).get();
    }

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        // Logica de negocio
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        if (pacienteRepository.findById(paciente.getIdPaciente()).isEmpty()) {
            System.out.println("Este paciente no existe");
            return new Paciente();
        } else {
            return pacienteRepository.save(paciente);
        }
    }

    @Override
    public void borrarPaciente(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }

    @Override
    public List<Paciente> buscarPorNombre(String nombre) {
        return pacienteRepository.findByNombre(nombre);
    }
}
