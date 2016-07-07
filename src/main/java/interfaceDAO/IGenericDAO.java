/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Peter
 */
public interface IGenericDAO<T, PK extends Serializable> {
        public void save(T entity);
        public T findById(PK id);
        public void delete(T entity);
        public void deleteById(PK id);
        public List<T> findAll();
        public void update(T entity);
}
