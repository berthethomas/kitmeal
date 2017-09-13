/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.services;

import fr.imie.kitmeal.beans.AddressBean;
import fr.imie.kitmeal.entities.Address;
import fr.imie.kitmeal.interfacesDao.IAddressDao;
import fr.imie.kitmeal.interfacesServices.IAddressService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thomasberthe
 */
@Service
@Transactional(transactionManager = "txManagerKitmeal")
public class AddressService implements IAddressService {

    @Autowired
    private IAddressDao addressDao;

    @Override
    public List<AddressBean> findAllAddress() {
        List<Address> addresses = addressDao.findAll();
        List<AddressBean> beans = new ArrayList<>();

        for (Address address : addresses) {
            AddressBean bean = new AddressBean();

            bean.setIdAddress(address.getIdAddress());
            bean.setNumero(address.getNumero());
            bean.setRue(address.getRue());
            bean.setVille(address.getVille());
            bean.setCodePostal(address.getCodePostal());
            bean.setPays(address.getPays());
            bean.setBatiment(address.getBatiment());
            bean.setEtage(address.getEtage());
            bean.setPorte(address.getPorte());

            beans.add(bean);
        }

        return beans;
    }

    @Override
    public AddressBean createAddress(AddressBean bean) {
        Address address = new Address();

        address.setNumero(bean.getNumero());
        address.setRue(bean.getRue());
        address.setVille(bean.getVille());
        address.setCodePostal(bean.getCodePostal());
        address.setPays(bean.getPays());
        address.setBatiment(bean.getBatiment());
        address.setEtage(bean.getEtage());
        address.setPorte(bean.getPorte());

        addressDao.create(address);

        bean.setIdAddress(address.getIdAddress());
        
        return bean;
    }

    @Override
    public AddressBean updateAddress(Integer idAddress, AddressBean bean) {
        Address address = addressDao.find(idAddress);

        //address.setIdAddress(bean.getIdAddress());
        address.setNumero(bean.getNumero());
        address.setRue(bean.getRue());
        address.setVille(bean.getVille());
        address.setCodePostal(bean.getCodePostal());
        address.setPays(bean.getPays());
        address.setBatiment(bean.getBatiment());
        address.setEtage(bean.getEtage());
        address.setPorte(bean.getPorte());

        addressDao.update(address);

        return bean;
    }

    @Override
    public AddressBean findAddress(Integer idAddress) {
        Address address = addressDao.find(idAddress);

        AddressBean bean = new AddressBean();

        bean.setIdAddress(address.getIdAddress());
        bean.setNumero(address.getNumero());
        bean.setRue(address.getRue());
        bean.setVille(address.getVille());
        bean.setCodePostal(address.getCodePostal());
        bean.setPays(address.getPays());
        bean.setBatiment(address.getBatiment());
        bean.setEtage(address.getEtage());
        bean.setPorte(address.getPorte());

        return bean;
    }

    @Override
    public void removeAddress(Integer idAddress) {
        addressDao.delete(addressDao.find(idAddress));
    }

}
