package com.argprog.argprogapp.controladores;

import com.argprog.argprogapp.entidades.Paciente;
import com.argprog.argprogapp.servicios.PacienteServicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
@Slf4j
public class PacienteControlador {

    private final PacienteServicio pacienteServicio;


    @GetMapping
    public ResponseEntity<List<Paciente>> getPacientes() {
        log.info("Entrando al end point");
        List<Paciente> pacientes = pacienteServicio.listarPacientes();
        if (pacientes.isEmpty()) {
            log.info("No encontro nada");
            return ResponseEntity.noContent().build();
        }
        log.info("Encontro pacientes los devuelve {}" , pacientes);
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable("id") Long id) {
        log.info("Entrando al end point");
        Paciente paciente = pacienteServicio.traerById(id);
        if (paciente==null) {
            log.info("No encontro nada");
            return ResponseEntity.noContent().build();
        }
        log.info("Encontro paciente lo devuelve {}" , paciente);
        return ResponseEntity.ok(paciente);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        log.info("Grabando paciente");
        Paciente pacienteDb = pacienteServicio.registrarPaciente(paciente);
        return ResponseEntity.ok(pacienteDb);
    }

    @PutMapping(value = "/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable("id") Long id, @RequestBody Paciente paciente) {
        log.info("Grabando paciente");
        paciente.setIdPaciente(id);
        Paciente pacienteDb = pacienteServicio.actualizar(paciente);
        return ResponseEntity.ok(pacienteDb);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> deletePaciente(@PathVariable("id")  Long id) {
        log.info("Grabando paciente");
        Paciente paciente = new Paciente();
        paciente.setIdPaciente(id);
        pacienteServicio.borrarPaciente(paciente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/buscar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Paciente>> getPacientesPorNombre(@RequestBody String nombre) {
        log.info("Buscando pacientes con nombre: {}", nombre);
        log.info("Entrando al end point");
        List<Paciente> pacientes = pacienteServicio.buscarPorNombre(nombre);
        if (pacientes.isEmpty()) {
            log.info("No encontro nada");
            return ResponseEntity.noContent().build();
        }
        log.info("Encontro pacientes los devuelve {}" , pacientes);
        return ResponseEntity.ok(pacientes);
    }


}
