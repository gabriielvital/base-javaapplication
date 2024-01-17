
package com.ifcoder.projetodacc_jpa.model.dao;

import java.util.List;

/**
 *
 * @author jose
 */
public interface IDao<T> {
    void save(T obj);
    void update(T obj);
    boolean delete(Long id);           
    T find(Long id);        
    List<T> findAll();
}
