package com.ifcoder.projetodacc_jpa.model.dao;

import com.ifcoder.projetodacc_jpa.factory.DatabaseJPA;
import com.ifcoder.projetodacc_jpa.model.entities.Disciplina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author jose
 */
public class DisciplinaDAO implements IDao<Disciplina> {

    private EntityManager entityManager;
    
    @Override
    public void save(Disciplina obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Disciplina obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
    
    @Override
    public Disciplina find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        //Lembrando que ao usar o find do JPA-Hibernate ele faz o cache pra gente automaticamente
        //E se estivéssemos utilizando algum tipo de relacionamento ele faria a estratégia LAZY e EAGER
        Disciplina disciplina = this.entityManager.find(Disciplina.class, id);
        
        this.entityManager.close();
        
        return disciplina;
    }
    
    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Disciplina disciplinaJPA = this.entityManager.find(Disciplina.class, id);
        if (disciplinaJPA != null) {
            this.entityManager.remove(disciplinaJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new RuntimeException("Error - Disciplina inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Disciplina> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        String jpql = " SELECT d "
             + " FROM Disciplina d ";

        TypedQuery qry = this.entityManager.createQuery(jpql, Disciplina.class);
        
        List<Disciplina> lst = qry.getResultList();        
        this.entityManager.close();
        return lst;
    }

    // Outros métodos específicos para Disciplina podem ser adicionados aqui, 
    // assim como o findByEmail foi para Funcionario.
    public Disciplina findByName(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT d "
                + " FROM Disciplina d "
                + " WHERE d.nome = :nome ";
        TypedQuery qry = this.entityManager.createQuery(jpql, Disciplina.class);
        qry.setParameter("nome", nome);

        List<Disciplina> lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0);  // Retorna a primeira ocorrência
        }
    }
    
    public List<Disciplina> filterByName(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        String jpql = " SELECT p "
                + " FROM Professor p "
                + " WHERE p.nome like :nome";
        TypedQuery qry = this.entityManager.createQuery(jpql, Disciplina.class);
        qry.setParameter("nome", nome+"%");
        
        List<Disciplina> lst = qry.getResultList();
        
        this.entityManager.close();
        return lst;
    }
}

