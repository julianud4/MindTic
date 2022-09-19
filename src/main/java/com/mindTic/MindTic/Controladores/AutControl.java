package com.mindTic.MindTic.Controladores;

import com.mindTic.MindTic.Entidades.Empleado;
import com.mindTic.MindTic.Entidades.Empresa;
import com.mindTic.MindTic.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AutControl {

    @Autowired
    private UsuarioDao usuariodao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Empleado empleado) {
        if (usuariodao.verificarLogin(empleado)) {
            return "OK";
        }
        return "FAIL";
    }
}

