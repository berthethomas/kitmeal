/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.services;

import fr.imie.kitmeal.beans.CategoryBean;
import fr.imie.kitmeal.entities.Category;
import fr.imie.kitmeal.interfacesDao.ICategoryDao;
import fr.imie.kitmeal.interfacesServices.ICategoryService;
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
public class CategoryService implements ICategoryService{
    
     @Autowired
    private ICategoryDao categoryDao;

    @Override
    public List<CategoryBean> findAllCategories() {
        List<Category> categories = categoryDao.findAll();
        List<CategoryBean> beans = new ArrayList<>();

        for (Category category : categories) {
            CategoryBean bean = new CategoryBean();
            
            bean.setNom(category.getNom()); 
            beans.add(bean);
        }

        return beans;
    }

    @Override
    public CategoryBean createCategory(CategoryBean bean) {
        Category category = new Category();
       
        category.setNom(bean.getNom());
        
        categoryDao.create(category);

        return bean;
    }

    @Override
    public CategoryBean updateCategory(Integer idCategory, CategoryBean bean) {
        Category category = categoryDao.find(idCategory);

        category.setNom(bean.getNom());
        categoryDao.update(category);

        return bean;
    }

    @Override
    public CategoryBean findCategory(Integer idCategory) {
         Category category = categoryDao.find(idCategory);

        CategoryBean bean = new CategoryBean();
        
        bean.setNom(category.getNom());
       
        return bean;
    }

    @Override
    public void removeCategory(Integer idCategory) {
        categoryDao.delete(categoryDao.find(idCategory));
    }
    
}
