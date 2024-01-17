/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcoder.projetodacc_jpa.model.dao;

import com.ifcoder.projetodacc_jpa.factory.DatabaseJPA;
import com.ifcoder.projetodacc_jpa.model.entities.Aluno;
import com.ifcoder.projetodacc_jpa.model.exceptions.AlunoException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author jose
 */
public class AlunoDAO implements IDao<Aluno> {

    private EntityManager entityManager;
    
    @Override
    public void save(Aluno obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Aluno obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Aluno find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Aluno a = this.entityManager.find(Aluno.class, id);

        this.entityManager.close();
        return a;
    }

    public List<Aluno> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        //Atenção para a 'tabela' Aluno, tem que ser a primeira letra MAIUSCULA pois na realidade 
        //se refere a classe Aluno!
        String jpql = " SELECT a "
                + " FROM Aluno a ";

        TypedQuery qry = this.entityManager.createQuery(jpql, Aluno.class);

        List lst = qry.getResultList();
        this.entityManager.close();
        return lst;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Aluno alunoJPA = this.entityManager.find(Aluno.class, id);
        if (alunoJPA != null) {
            this.entityManager.remove(alunoJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new AlunoException("Error - Aluno inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    public Aluno findByMatricula(String matricula) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Aluno a "
                + " WHERE a.matricula like :matricula";
        TypedQuery qry = this.entityManager.createQuery(jpql, Aluno.class);
        qry.setParameter("matricula", matricula);

        List lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Aluno) lst.get(0);
        }
    }

    public List<Aluno> filterByName(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT a "
                + "FROM Aluno a "
                + "WHERE a.nome like :nome";
        TypedQuery qry = this.entityManager.createQuery(jpql, Aluno.class);
        qry.setParameter("nome", nome + "%");

        List<Aluno> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

}
