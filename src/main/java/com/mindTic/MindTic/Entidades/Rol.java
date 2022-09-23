package com.mindTic.MindTic.Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Rol {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) @Column(name="idrol")
    private int idrol;
    @Setter @Getter @Column(name="tiporol")
    private String tiporol;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true) @Setter @Getter
    private List<Empleado> EmpleadosLista;
    public Rol(int idrol, String tiporol) {
        this.idrol = idrol;
        this.tiporol = tiporol;
    }

    public Rol() {
    }
}
