package com.argprog.argprogapp;

import com.argprog.argprogapp.entidades.Paciente;
import com.argprog.argprogapp.repositorios.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PacienteTest {



    public static void main(String[] args) {

        Paciente paciente = new Paciente();
        paciente.setApellido("Perez");
        paciente.setNombre("Nico");
        System.out.println(paciente);

    }
}
