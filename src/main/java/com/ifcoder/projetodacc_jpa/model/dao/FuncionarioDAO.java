package com.ifcoder.projetodacc_jpa.model.dao;

import com.ifcoder.projetodacc_jpa.factory.DatabaseJPA;
import com.ifcoder.projetodacc_jpa.model.entities.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author jose
 */
public class FuncionarioDAO implements IDao<Funcionario> {

    private EntityManager entityManager;
    
    @Override
    public void save(Funcionario obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Funcionario obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Funcionario find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        //Lembrando que ao usar o find do JPA-Hibernate ele faz o cache pra gente automaticamente
        //E se estivéssemos utilizando algum tipo de relacionamento ele faria a estratégia LAZY e EAGER
        Funcionario f = this.entityManager.find(Funcionario.class, id);
        
        this.entityManager.close();
        
        return f;
    }
    
    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Funcionario funcionarioJPA = this.entityManager.find(Funcionario.class, id);
        if (funcionarioJPA != null) {
            this.entityManager.remove(funcionarioJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new RuntimeException("Error - Funcionario inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Funcionario> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        String jpql = " SELECT p "
                     + " FROM Funcionario p ";

        TypedQuery qry = this.entityManager.createQuery(jpql, Funcionario.class);
        
        List lst = qry.getResultList();        
        this.entityManager.close();
        return lst;
                
    }

    public Funcionario findByEmail(String email) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        String jpql = " SELECT f "
             + " FROM Funcionario f "
             + " WHERE f.email like :email ";
        TypedQuery qry = this.entityManager.createQuery(jpql, Funcionario.class);
        qry.setParameter("email", email);
        
        List lst = qry.getResultList();
        this.entityManager.close();
        
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Funcionario) lst.get(0);
        }                
    }    
   

}
