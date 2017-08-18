/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.dao;

import fr.imie.kitmeal.entities.Category;
import fr.imie.kitmeal.interfacesDao.ICategoryDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura
 */
@Repository
public class CategoryDao extends AbstractGenericDaoKitmeal<Category> implements ICategoryDao{

    @Override
    public List<Category> findAll() {
        String hql = "FROM Category";

        Query query = getSession().createQuery(hql);

        List<Category> categories = (List<Category>) query.list();

        return categories;    }
    
}
