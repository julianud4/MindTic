package com.mindTic.MindTic.dao;

import com.mindTic.MindTic.Entidades.Empleado;
import com.mindTic.MindTic.Entidades.Empresa;
import com.mindTic.MindTic.Entidades.MovimientoDinero;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class usuarioimp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Empresa> listarEmpresa() {
        String query = "SELECT idempresa, nombre, direccion, telefono, nit, fecha_creacion, fecha_act FROM Empresa";
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
    public void eliminarEmpleados(Long id) {
        Empleado empleado = entityManager.find(Empleado.class, id);
        entityManager.remove(empleado);
    }

    @Override
    public boolean verificarLogin(@NotNull Empleado empleado) {
        String query = "FROM Empleado WHERE email = :email AND password= :password";
        List <Empleado> lista = entityManager.createQuery(query)
                .setParameter("email",empleado.getEmail())
                .setParameter("password",empleado.getPassword())
                .getResultList();
        return !lista.isEmpty();
        }
    }
