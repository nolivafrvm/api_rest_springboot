package com.argprog.argprogapp.entidades;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name="tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    private String nombre;
    private String apellido;

    @Column(unique = true)
    private String nroTelefono;

    private String calle;
    private String nroCalle;
    private LocalDate fechaNacimiento;


}
