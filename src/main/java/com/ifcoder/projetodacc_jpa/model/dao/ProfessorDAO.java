/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcoder.projetodacc_jpa.model.dao;

import com.ifcoder.projetodacc_jpa.factory.DatabaseJPA;
import com.ifcoder.projetodacc_jpa.model.entities.Professor;
import com.ifcoder.projetodacc_jpa.model.exceptions.ProfessorException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author jose
 */
public class ProfessorDAO implements IDao<Professor> {

    private EntityManager entityManager;
    
    @Override
    public void save(Professor obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Professor obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Professor find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        // Utilizando o find do JPA-Hibernate que faz cache automaticamente
        // E se estivéssemos utilizando algum tipo de relacionamento ele faria a estratégia LAZY e EAGER
        Professor professor = this.entityManager.find(Professor.class, id);

        this.entityManager.close();

        return professor;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Professor professorJPA = this.entityManager.find(Professor.class, id);
        if (professorJPA != null) {
            this.entityManager.remove(professorJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new ProfessorException("Error - Aluno inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Professor> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT p FROM Professor p";
        TypedQuery qry = this.entityManager.createQuery(jpql, Professor.class);

        List<Professor> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

    public Professor findByCpf(String cpf) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Professor a "
                + " WHERE a.cpf like :cpf";
        TypedQuery<Professor> qry = this.entityManager.createQuery(jpql, Professor.class);
        qry.setParameter("cpf", cpf);

        List lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Professor) lst.get(0);
        }
    }

    public List<Professor> filterByName(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT p "
                + " FROM Professor p "
                + " WHERE p.nome like :nome ";
        TypedQuery<Professor> qry = this.entityManager.createQuery(jpql, Professor.class);
        qry.setParameter("nome", nome + "%");

        List<Professor> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

}
