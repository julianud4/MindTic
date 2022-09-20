package com.mindTic.MindTic.Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity @Table(name = "movimientosdinero")
public class MovimientoDinero {

    @Setter @Getter @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name="idmovimiento")
    private Long idmovimiento;

    @Setter @Getter @Column(name="monto")
    private float monto;

    @Setter @Getter @Column(name="tipomovimiento")
    private boolean tipomovimiento;

    @Setter @Getter @Column(name="conceptomovimiento")
    private String conceptomovimiento;

    @Getter    @Setter @Column(name="fecha_creacion")
    private Date fecha_creacion;

    @Getter    @Setter @Column(name="fecha_act")
    private Date fecha_act;

    @ManyToOne() @Setter @Getter
    @JoinColumn(name = "idempleado")
    private Empleado empleado;
}
