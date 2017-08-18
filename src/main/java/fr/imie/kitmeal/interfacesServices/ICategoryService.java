/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesServices;

import fr.imie.kitmeal.beans.CategoryBean;
import java.util.List;

/**
 *
 * @author Laura
 */
public interface ICategoryService {
    
    public List<CategoryBean> findAllCategories();

    public CategoryBean createCategory(CategoryBean bean);
    
    public CategoryBean updateCategory(Integer idCategory, CategoryBean bean);
    
    public CategoryBean findCategory(Integer idCategory);
    
    public void removeCategory(Integer idCategory);
}
