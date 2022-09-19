package com.mindTic.MindTic.Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresa {


    @Getter    @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="idempresa")
    private long idempresa;

    @Getter    @Setter @Column(name="nombre")
    private String nombre;

    @Getter    @Setter @Column(name="direccion")
    private String direccion;

    @Getter    @Setter @Column(name="telefono")
    private String telefono;

    @Getter    @Setter @Column(name="nit")
    private String nit;

    @Getter    @Setter @Column(name="fecha_creacion")
    private Date fecha_creacion;

    @Getter    @Setter @Column(name="fecha_act")
    private Date fecha_act;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true) @Setter @Getter
    private List<Empleado> EmpleadosList;

    public Empresa() {
    }

    public Empresa(long idempresa, String nombre, String direccion, String telefono, String nit, Date fecha_creacion, Date fecha_act, List<Empleado> empleadosList) {
        this.idempresa = idempresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
        this.fecha_creacion = fecha_creacion;
        this.fecha_act = fecha_act;
        EmpleadosList = empleadosList;
    }

}
