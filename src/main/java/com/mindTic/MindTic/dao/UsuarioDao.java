package com.mindTic.MindTic.dao;

import com.mindTic.MindTic.Entidades.Empleado;
import com.mindTic.MindTic.Entidades.Empresa;
import com.mindTic.MindTic.Entidades.MovimientoDinero;

import java.util.List;

public interface UsuarioDao {

    List<Empresa> listarEmpresa();
    List<Empleado> listarEmpleado();
    List<MovimientoDinero> listarMovimiento();
    void eliminarEmpleados(Long id);
    boolean verificarLogin(Empleado empleado);
}
