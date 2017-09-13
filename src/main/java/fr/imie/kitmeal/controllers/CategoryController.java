/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.CategoryBean;
import fr.imie.kitmeal.interfacesServices.ICategoryService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Laura
 */
@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findAllCategories(HttpSession session,
            HttpServletRequest request) {
        List<CategoryBean> beans = categoryService.findAllCategories();

        return new ModelAndView("/admin/category/category.jsp", "bean", beans);
    }

    @RequestMapping(value = "/create/{bean}", method = RequestMethod.POST)
    public ModelAndView createCategory(HttpSession session, CategoryBean bean,
            HttpServletRequest request) {
        categoryService.createCategory(bean);

        return new ModelAndView("redirect:/app/categories");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCreateCategory(HttpSession session,
            HttpServletRequest request) {
        CategoryBean bean = new CategoryBean();

        return new ModelAndView("/admin/category/create.jsp", "bean", bean);
    }

    @RequestMapping(value = "/update/{idCategory}/{bean}", method = RequestMethod.POST)
    public ModelAndView updateCategory(HttpSession session, CategoryBean bean,
            @PathVariable Integer idCategory, HttpServletRequest request) {
        categoryService.updateCategory(idCategory, bean);

        return new ModelAndView("redirect:/app/categories");
    }

    @RequestMapping(value = "/update/{idCategory}", method = RequestMethod.GET)
    public ModelAndView showUpdateCategory(HttpSession session,
            @PathVariable Integer idCategory, HttpServletRequest request) {
        CategoryBean bean = categoryService.findCategory(idCategory);

        return new ModelAndView("/admin/category/update.jsp", "bean", bean);
    }

    @RequestMapping(value = "/find/{idCategory}", method = RequestMethod.GET)
    public ResponseEntity<CategoryBean> findCategory(HttpSession session, @PathVariable Integer idCategory,
            HttpServletRequest request) {
        CategoryBean bean = categoryService.findCategory(idCategory);

        return new ResponseEntity<CategoryBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idCategory}", method = RequestMethod.GET)
    public ModelAndView removeCategory(HttpSession session, @PathVariable Integer idCategory,
            HttpServletRequest request) {
        categoryService.removeCategory(idCategory);

        return new ModelAndView("redirect:/app/categories");
    }

}
