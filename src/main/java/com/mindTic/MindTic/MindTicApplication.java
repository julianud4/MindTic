package com.mindTic.MindTic;

import Entidades.Empleado;
import Entidades.Empresa;
import Entidades.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MindTicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MindTicApplication.class, args);

		Empresa empresa = new Empresa();
		empresa.setNombre("J3F");
		empresa.setDireccion("Calle 123");
		empresa.setTelefono("3057730972");
		empresa.setNit("12349876");

		Empleado empleado = new Empleado();
		empleado.setNombreCompleto("Julian Alfonso");
		empleado.setEmail("prueba@prueba.com");
		empleado.setEmpresa(empresa);
		empleado.setIdRol("Admin");

		MovimientoDinero movimiento = new MovimientoDinero();
		movimiento.setMonto(45000);
		movimiento.setTipoMovimiento(true);
		movimiento.setConceptoMovimineto("Venta");
		movimiento.setEmpleado(empleado);
	}
}
