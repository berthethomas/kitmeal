/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesServices;

import fr.imie.kitmeal.beans.UserIngredientBean;
import java.util.List;

/**
 *
 * @author Laura
 */
public interface IUserIngredientService {

    public List<UserIngredientBean> findAllUserIngredients();

    public UserIngredientBean createUserIngredient(UserIngredientBean bean);

    public UserIngredientBean updateUserIngredient(Integer idUserIngredient, UserIngredientBean bean);

    public UserIngredientBean findUserIngredient(Integer idUserIngredient);

    public void removeUserIngredient(Integer idUserIngredient);

}
