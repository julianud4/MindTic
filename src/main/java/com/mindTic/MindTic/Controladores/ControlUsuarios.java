package com.mindTic.MindTic.Controladores;

import com.mindTic.MindTic.Entidades.Empresa;
import com.mindTic.MindTic.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControlUsuarios {

    @Autowired
    private UsuarioDao usuariodao;

    @RequestMapping(value = "prueba")
    public List<Empresa> listarEmpresa(){
        return usuariodao.listarEmpresa();
    }

}
