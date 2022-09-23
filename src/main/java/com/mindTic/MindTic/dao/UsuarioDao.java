package com.mindTic.MindTic.dao;

import com.mindTic.MindTic.Entidades.Empleado;
import com.mindTic.MindTic.Entidades.Empresa;
import com.mindTic.MindTic.Entidades.MovimientoDinero;
import com.mindTic.MindTic.Entidades.Rol;

import java.util.List;

public interface UsuarioDao {

    List<Empresa> listarEmpresa();
    List<Empleado> listarEmpleado();
    List<MovimientoDinero> listarMovimiento();
    List<Rol> listarRol();
    void eliminarEmpleados(Long id);
    void eliminarEmpresas(Long id);
    void eliminarMovimientos(Long id);
    Empleado verificarLogin(Empleado empleado);
    void nempresa(Empresa empresa);

    void nempleado(Empleado empleadoa);
}
