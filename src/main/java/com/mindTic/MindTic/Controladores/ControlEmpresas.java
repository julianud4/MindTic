package com.mindTic.MindTic.Controladores;

import com.mindTic.MindTic.Entidades.Empleado;
import com.mindTic.MindTic.Entidades.Empresa;
import com.mindTic.MindTic.Entidades.MovimientoDinero;
import com.mindTic.MindTic.Entidades.Rol;
import com.mindTic.MindTic.Utils.JWTUtil;
import com.mindTic.MindTic.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
public class ControlEmpresas {

    @Autowired
    private UsuarioDao usuariodao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/listarempresas",method = RequestMethod.GET)
    public List<Empresa> listarEmpresa(){ return usuariodao.listarEmpresa();    }
    @RequestMapping(value = "api/listarempleados",method = RequestMethod.GET)
    public List<Empleado> listarEmpleado(@RequestHeader(value = "Authorization") String token){
        String empleadoid=jwtUtil.getKey(token);
        if(empleadoid==null){
            return new ArrayList<>();
        }
        return usuariodao.listarEmpleado();
    }
    @RequestMapping(value = "api/listarmovimientos",method = RequestMethod.GET)
    public List<MovimientoDinero> listarMovimiento(){
        return usuariodao.listarMovimiento();
    }
    @RequestMapping(value = "api/listarrol",method = RequestMethod.GET)
    public List<Rol> listarRol(){
        return usuariodao.listarRol();
    }

    @RequestMapping(value = "api/listarempleados/{id}",method = RequestMethod.DELETE)
    public void eliminarEmpleados(@PathVariable Long id){
        usuariodao.eliminarEmpleados(id);}
    @RequestMapping(value = "api/listarempresas/{id}",method = RequestMethod.DELETE)
    public void eliminarEmpresas(@PathVariable Long id){
        usuariodao.eliminarEmpresas(id);}
    @RequestMapping(value = "api/listarmovimientos/{id}",method = RequestMethod.DELETE)
    public void eliminarMovimientos(@PathVariable Long id) { usuariodao.eliminarMovimientos(id);}

    @RequestMapping(value = "api/listarempresas",method = RequestMethod.POST)
    public void nuevaEmpresa(@RequestBody Empresa empresa){ usuariodao.nempresa(empresa);    }
    @RequestMapping(value = "api/listarempleados",method = RequestMethod.POST)
    public void nuevoEmpleado(@RequestBody Empleado empleado){
            usuariodao.nempleado(empleado);}
}