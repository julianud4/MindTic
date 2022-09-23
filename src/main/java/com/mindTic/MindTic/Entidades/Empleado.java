package com.mindTic.MindTic.Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @Table(name = "empleados")
public class Empleado {

    @Getter    @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="idempleado")
    private Long idempleado;

    @Setter @Getter @Column(name="nombrecompleto")
    private String nombrecompleto;

    @Setter @Getter @Column(name="email")
    private String email;

    @Setter @Getter @Column(name="password")
    private String password;

    @ManyToOne()
    @JoinColumn(name = "idrol") @Setter @Getter
    private Rol rol;

    @Getter    @Setter @Column(name="fecha_creacion")
    private Date fecha_creacion;

    @Getter    @Setter @Column(name="fecha_act")
    private Date fecha_act;

    @ManyToOne()
    @JoinColumn(name = "idempresa") @Setter @Getter
    private Empresa empresa;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true) @Setter @Getter
    private List<MovimientoDinero> moviminetosList;

    @Setter @Getter @Column(name="empresaid")
    protected long empresaid;

    @Setter @Getter @Column(name="rolid")
    private int rolid;



}
