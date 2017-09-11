/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.services;

import fr.imie.kitmeal.beans.UserIngredientBean;
import fr.imie.kitmeal.entities.UserIngredient;
import fr.imie.kitmeal.interfacesDao.IIngredientDao;
import fr.imie.kitmeal.interfacesDao.IUserDao;
import fr.imie.kitmeal.interfacesDao.IUserIngredientDao;
import fr.imie.kitmeal.interfacesServices.IIngredientService;
import fr.imie.kitmeal.interfacesServices.IUserEventService;
import fr.imie.kitmeal.interfacesServices.IUserIngredientService;
import fr.imie.kitmeal.interfacesServices.IUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Laura
 */
@Service
@Transactional(transactionManager = "txManagerKitmeal")
public class UserIngredientService implements IUserIngredientService {

    @Autowired
    private IUserIngredientDao userIngredientDao;

    @Autowired
    IUserService userService;
    @Autowired
    IUserDao userDao;

    @Autowired
    IIngredientService ingredientService;
    @Autowired
    IIngredientDao ingredientDao;

    @Override
    public List<UserIngredientBean> findAllUserIngredients() {
        List<UserIngredient> userIngredients = userIngredientDao.findAll();
        List<UserIngredientBean> beans = new ArrayList<>();

        for (UserIngredient userIngredient : userIngredients) {
            UserIngredientBean bean = new UserIngredientBean();

            bean.setIdUserIngredient(userIngredient.getIdUserIngredient());
            bean.setQuantite(userIngredient.getQuantite());
            bean.setIngredient(ingredientService.findIngredient(userIngredient.getIngredient().getIdIngredient()));
            bean.setUser(userService.findUser(userIngredient.getUser().getIdUser()));

            beans.add(bean);
        }

        return beans;
    }

    @Override
    public UserIngredientBean createUserIngredient(UserIngredientBean bean) {
        UserIngredient userIngredient = new UserIngredient();

        userIngredient.setQuantite(bean.getQuantite());
        userIngredient.setIngredient(ingredientDao.find(bean.getIngredient().getIdIngredient()));
        userIngredient.setUser(userDao.find(bean.getUser().getIdUser()));

        userIngredientDao.create(userIngredient);

        return bean;
    }

    @Override
    public UserIngredientBean updateUserIngredient(Integer idUserIngredient, UserIngredientBean bean) {
        UserIngredient userIngredient = userIngredientDao.find(idUserIngredient);

        userIngredient.setQuantite(bean.getQuantite());
        userIngredient.setIngredient(ingredientDao.find(bean.getIngredient().getIdIngredient()));
        userIngredient.setUser(userDao.find(bean.getUser().getIdUser()));

        userIngredientDao.update(userIngredient);

        return bean;
    }

    @Override
    public UserIngredientBean findUserIngredient(Integer idUserIngredient) {
        UserIngredient userIngredient = userIngredientDao.find(idUserIngredient);

        UserIngredientBean bean = new UserIngredientBean();

        bean.setIdUserIngredient(userIngredient.getIdUserIngredient());
        bean.setQuantite(userIngredient.getQuantite());
        bean.setIngredient(ingredientService.findIngredient(userIngredient.getIngredient().getIdIngredient()));
        bean.setUser(userService.findUser(userIngredient.getUser().getIdUser()));

        return bean;
    }

    @Override
    public void removeUserIngredient(Integer idUserIngredient) {
        userIngredientDao.delete(userIngredientDao.find(idUserIngredient));
    }

}
