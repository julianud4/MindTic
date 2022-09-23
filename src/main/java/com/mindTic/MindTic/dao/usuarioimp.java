package com.mindTic.MindTic.dao;

import com.mindTic.MindTic.Entidades.Empleado;
import com.mindTic.MindTic.Entidades.Empresa;
import com.mindTic.MindTic.Entidades.MovimientoDinero;
import com.mindTic.MindTic.Entidades.Rol;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class usuarioimp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Empresa> listarEmpresa() {
        String query = "SELECT idempresa, nombre, direccion, telefono, nit FROM Empresa";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Empleado> listarEmpleado() {
        String query = "SELECT idempleado, nombrecompleto, email, rol.tiporol, empresa.nombre FROM Empleado";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<MovimientoDinero> listarMovimiento() {
        String query = "SELECT idmovimiento, monto, tipomovimiento, conceptomovimiento, fecha_creacion, fecha_act FROM MovimientoDinero";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Rol> listarRol() {
        String query = "SELECT idrol, tiporol FROM Rol";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminarEmpleados(Long id) {
        Empleado empleado = entityManager.find(Empleado.class, id);
        entityManager.remove(empleado);
    }

    @Override
    public void eliminarEmpresas(Long id) {
        Empresa empresa = entityManager.find(Empresa.class, id);
        entityManager.remove(empresa);
    }

    @Override
    public void eliminarMovimientos(Long id) {
        MovimientoDinero movimiento = entityManager.find(MovimientoDinero.class, id);
        entityManager.remove(movimiento);
    }

    @Override
    public Empleado verificarLogin(Empleado empleado) {
        String query = "FROM Empleado WHERE email = :email";
        List <Empleado> lista = entityManager.createQuery(query)
                .setParameter("email",empleado.getEmail())
                .getResultList();

        if (lista.isEmpty()){
            return null;
        }

        String contrasena=lista.get(0).getPassword();
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(contrasena, empleado.getPassword())){
            return lista.get(0);
        }
        return null;
        }

    @Override
    public void nempresa(Empresa empresa) {
        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
        System.out.println(date);
        empresa.setFecha_creacion(date);
        empresa.setFecha_act(date);
        entityManager.merge(empresa);
    }
    @Override
    public void nempleado(Empleado empleado) {
        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        empleado.setPassword(argon2.hash(1,1024,1, empleado.getPassword()));
        empleado.setRol(entityManager.find(Rol.class, empleado.getRolid()));
        empleado.setEmpresa(entityManager.find(Empresa.class, empleado.getEmpresaid()));
        empleado.setFecha_creacion(date);
        empleado.setFecha_act(date);
        entityManager.merge(empleado);
    }
}
