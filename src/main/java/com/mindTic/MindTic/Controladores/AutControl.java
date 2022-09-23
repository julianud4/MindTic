package com.mindTic.MindTic.Controladores;

import com.mindTic.MindTic.Entidades.Empleado;
import com.mindTic.MindTic.Utils.JWTUtil;
import com.mindTic.MindTic.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AutControl {

    @Autowired
    private UsuarioDao usuariodao;

    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public List login(@RequestBody Empleado empleado) {
        Empleado empleadologueado=usuariodao.verificarLogin(empleado);
        List token =new ArrayList();
        if (empleadologueado!=null) {
            String tokenJwt=jwtUtil.create(String.valueOf(empleadologueado.getIdempleado()),empleadologueado.getEmail());
            token.add(tokenJwt);
            token.add(empleadologueado.getNombrecompleto());
            return token;
                    }
        token.add("FAIL");
        token.add("FAIL");
        return token;
    }
}

