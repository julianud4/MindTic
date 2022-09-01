package com.mindTic.MindTic.dao;

import com.mindTic.MindTic.Entidades.Empresa;
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
        String query = "FROM Empresa";
        return entityManager.createQuery(query).getResultList();
    }
}
