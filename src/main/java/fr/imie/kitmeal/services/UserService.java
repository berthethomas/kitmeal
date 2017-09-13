/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.services;

import fr.imie.kitmeal.beans.UserBean;
import fr.imie.kitmeal.entities.User;
import fr.imie.kitmeal.interfacesDao.IAddressDao;
import fr.imie.kitmeal.interfacesDao.IUserDao;
import fr.imie.kitmeal.interfacesServices.IAddressService;
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
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    IAddressService addressService;
    @Autowired
    IAddressDao addressDao;

    @Override
    public List<UserBean> findAllUsers() {
        List<User> users = userDao.findAll();
        List<UserBean> beans = new ArrayList<>();

        for (User user : users) {
            UserBean bean = new UserBean();

            bean.setIdUser(user.getIdUser());
            bean.setPrenom(user.getPrenom());
            bean.setNom(user.getNom());
            bean.setMail(user.getMail());
            bean.setTelephone(user.getTelephone());
            bean.setBirthday(user.getBirthday());
            bean.setUsername(user.getUsername());
            bean.setPassword(user.getPassword());
            bean.setPhoto(user.getPhoto());
            bean.setRole(user.getRole());
            bean.setAddress(addressService.findAddress(user.getAdresse().getIdAddress()));

            beans.add(bean);
        }

        return beans;
    }

    @Override
    public UserBean createUser(UserBean bean) {
        User user = new User();
        user.setPrenom(bean.getPrenom());
        user.setNom(bean.getNom());
        user.setMail(bean.getMail());
        user.setTelephone(bean.getTelephone());
        user.setBirthday(bean.getBirthday());
        user.setUsername(bean.getUsername());
        user.setPassword(bean.getPassword());
        user.setPhoto(bean.getPhoto());
        user.setRole("user");
        user.setAdresse(addressDao.find(bean.getAddress().getIdAddress()));

        userDao.create(user);

        return bean;
    }

    @Override
    public UserBean updateUser(Integer idUser, UserBean bean) {
        User user = userDao.find(idUser);

        user.setPrenom(bean.getPrenom());
        user.setNom(bean.getNom());
        user.setMail(bean.getMail());
        user.setTelephone(bean.getTelephone());
        user.setBirthday(bean.getBirthday());
        user.setUsername(bean.getUsername());
        user.setPassword(bean.getPassword());
        user.setPhoto(bean.getPhoto());

        userDao.update(user);
        
        bean.setIdUser(user.getIdUser());

        return bean;
    }

    @Override
    public UserBean findUser(Integer idUser) {
        User user = userDao.find(idUser);

        UserBean bean = new UserBean();

        bean.setIdUser(user.getIdUser());
        bean.setPrenom(user.getPrenom());
        bean.setNom(user.getNom());
        bean.setMail(user.getMail());
        bean.setTelephone(user.getTelephone());
        bean.setBirthday(user.getBirthday());
        bean.setUsername(user.getUsername());
        bean.setPassword(user.getPassword());
        bean.setPhoto(user.getPhoto());
        bean.setAddress(addressService.findAddress(user.getAdresse().getIdAddress()));

        return bean;
    }

    @Override
    public void removeUser(Integer idUser) {
        userDao.delete(userDao.find(idUser));
    }

}
