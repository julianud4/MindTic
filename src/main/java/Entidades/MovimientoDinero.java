package Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity @Table(name = "MovimientosDinero")
public class MovimientoDinero {

    @Setter @Getter @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name="idMovimiento")
    private String idMovimiento;

    @Setter @Getter @Column(name="monto")
    private float monto;

    @Setter @Getter @Column(name="tipoMovimiento")
    private boolean tipoMovimiento;

    @Setter @Getter @Column(name="conceptoMovimiento")
    private String conceptoMovimineto;

    @Getter    @Setter @Column(name="fecha_creacion")
    private Date fecha_creacion;

    @Getter    @Setter @Column(name="fecha_act")
    private Date fecha_act;

    @ManyToOne() @Setter @Getter
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;
}
