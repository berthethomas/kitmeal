/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.services;

import fr.imie.kitmeal.beans.UniteBean;
import fr.imie.kitmeal.entities.Unite;
import fr.imie.kitmeal.interfacesDao.IUniteDao;
import fr.imie.kitmeal.interfacesServices.IUniteService;
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
public class UniteService implements IUniteService {

    @Autowired
    private IUniteDao uniteDao;

    @Override
    public List<UniteBean> findAllUnites() {
        List<Unite> unites = uniteDao.findAll();
        List<UniteBean> beans = new ArrayList<>();

        for (Unite unite : unites) {
            UniteBean bean = new UniteBean();

            bean.setNom(unite.getNom());

            beans.add(bean);
        }

        return beans;
    }

    @Override
    public UniteBean createUnite(UniteBean bean) {
        Unite unite = new Unite();
        unite.setNom(bean.getNom());

        uniteDao.create(unite);

        return bean;
    }

    @Override
    public UniteBean updateUnite(Integer idUnite, UniteBean bean) {
        Unite unite = uniteDao.find(idUnite);

        unite.setNom(bean.getNom());

        uniteDao.update(unite);

        return bean;
    }

    @Override
    public UniteBean findUnite(Integer idUnite) {
        Unite unite = uniteDao.find(idUnite);

        UniteBean bean = new UniteBean();
        bean.setNom(unite.getNom());

        return bean;
    }

    @Override
    public void removeUnite(Integer idUnite) {
        uniteDao.delete(uniteDao.find(idUnite));
    }

}
