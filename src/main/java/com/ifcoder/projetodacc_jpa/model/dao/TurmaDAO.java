package com.ifcoder.projetodacc_jpa.model.dao;


import com.ifcoder.projetodacc_jpa.factory.DatabaseJPA;
import com.ifcoder.projetodacc_jpa.model.entities.Turma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
/**
 *
 * @author jose
 */
public class TurmaDAO implements IDao<Turma> {

    private EntityManager entityManager;
    
    @Override
    public void save(Turma obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Turma obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Turma find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Turma t = this.entityManager.find(Turma.class, id);

        this.entityManager.close();
        return t;
    }
    
     @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Turma turmaJPA = this.entityManager.find(Turma.class, id);
        if (turmaJPA != null) {
            this.entityManager.remove(turmaJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new RuntimeException("Error - Turma inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Turma> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT t "
             + " FROM Turma t ";

        TypedQuery qry = this.entityManager.createQuery(jpql, Turma.class);

        List<Turma> lst = qry.getResultList();
        this.entityManager.close();
        return lst;
    }

    public Turma findByName(String nome) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT t "
             + " FROM Turma t "
             + " WHERE t.nome LIKE :nome";
        TypedQuery qry = this.entityManager.createQuery(jpql, Turma.class);
        qry.setParameter("nome", nome);

        List<Turma> lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0);
        }                
    }  

    public List<Turma> filterByYear(int ano) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT t "
                + " FROM Turma t "
                + " WHERE t.ano = :ano";
        TypedQuery qry = this.entityManager.createQuery(jpql, Turma.class);
        qry.setParameter("ano", ano);

        List<Turma> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

}
