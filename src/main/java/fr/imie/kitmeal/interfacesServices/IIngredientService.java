/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesServices;

import fr.imie.kitmeal.beans.IngredientBean;
import java.util.List;

/**
 *
 * @author thomasberthe
 */
public interface IIngredientService {

    public List<IngredientBean> findAllIngredients();

    public IngredientBean createIngredient(IngredientBean bean);

    public IngredientBean updateIngredient(Integer idIngredient, IngredientBean bean);

    public IngredientBean findIngredient(Integer idIngredient);

    public void removeIngredient(Integer idIngredient);
}
