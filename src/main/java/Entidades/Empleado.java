package Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @Table(name = "Empleados")
public class Empleado {

    @Setter @Getter @Id @GeneratedValue (strategy = GenerationType.AUTO) @Column(name="idEmpleado")
    private Long idEmpleado;

    @Setter @Getter @Column(name="nombreCompleto")
    private String nombreCompleto;

    @Setter @Getter @Column(name="email")
    private String email;

    @Setter @Getter @Column(name="idRol")
    private String idRol;

    @Getter    @Setter @Column(name="fecha_creacion")
    private Date fecha_creacion;

    @Getter    @Setter @Column(name="fecha_act")
    private Date fecha_act;

    @ManyToOne()
    @JoinColumn(name = "idEmpresa") @Setter @Getter
    private Empresa empresa;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true) @Setter @Getter
    private List<MovimientoDinero> moviminetosList;

}
