package com.mindTic.MindTic.Controladores;

import com.mindTic.MindTic.Entidades.Empleado;
import com.mindTic.MindTic.Entidades.Empresa;
import com.mindTic.MindTic.Entidades.MovimientoDinero;
import com.mindTic.MindTic.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.GregorianCalendar;
import java.util.List;

@RestController
public class ControlEmpresas {

    @Autowired
    private UsuarioDao usuariodao;

    @RequestMapping(value = "api/listarempresas",method = RequestMethod.GET)
    public List<Empresa> listarEmpresa(){
        return usuariodao.listarEmpresa();
    }

    @RequestMapping(value = "api/listarempleados/{id}",method = RequestMethod.DELETE)
    public void eliminarEmpleados(@PathVariable Long id){
        usuariodao.eliminarEmpleados(id);
    }
    @RequestMapping(value = "api/listarempleados")
    public List<Empleado> listarEmpleado(){
        return usuariodao.listarEmpleado();
    }

    @RequestMapping(value = "api/listarmovimientos")
    public List<MovimientoDinero> listarMovimiento(){
        return usuariodao.listarMovimiento();
    }

}
