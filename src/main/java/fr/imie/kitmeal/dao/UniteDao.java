/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.dao;

import fr.imie.kitmeal.entities.Unite;
import fr.imie.kitmeal.interfacesDao.IUniteDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thomasberthe
 */
@Repository
public class UniteDao extends AbstractGenericDaoKitmeal<Unite> implements IUniteDao {

    @Override
    public List<Unite> findAll() {
        String hql = "FROM Unite";

        Query query = getSession().createQuery(hql);

        List<Unite> unites = (List<Unite>) query.list();

        return unites;
    }

}
