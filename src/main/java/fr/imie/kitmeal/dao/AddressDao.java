/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.dao;

import fr.imie.kitmeal.entities.Address;
import fr.imie.kitmeal.interfacesDao.IAddressDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thomasberthe
 */
@Repository
public class AddressDao extends AbstractGenericDaoKitmeal<Address> implements IAddressDao {

    @Override
    public List<Address> findAll() {
        String hql = "FROM Address";

        Query query = getSession().createQuery(hql);

        List<Address> adresses = (List<Address>) query.list();

        return adresses;
    }

}
