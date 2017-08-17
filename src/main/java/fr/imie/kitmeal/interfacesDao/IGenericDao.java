/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesDao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Laura
 */
public interface IGenericDao <PK extends Serializable, T> {
    
    T create(T t);

    void delete(T entity);

    T find(Long id);

    T update(T t);
    
    List<T> findAll();

}
