package com.argprog.argprogapp.servicios;

import com.argprog.argprogapp.entidades.Paciente;

import java.util.List;

public interface PacienteServicio {

    List<Paciente> listarPacientes();

    Paciente traerById(Long id);
    Paciente registrarPaciente(Paciente paciente);
    Paciente actualizar(Paciente paciente);
    void borrarPaciente(Paciente paciente);
    List<Paciente> buscarPorNombre(String nombre);
}
