/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.UniteBean;
import fr.imie.kitmeal.interfacesServices.IUniteService;
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
 * @author thomasberthe
 */
@RestController
@RequestMapping(value = "/unites")
public class UniteController {

    @Autowired
    IUniteService uniteService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<UniteBean>> findAllUnites(HttpSession session,
            HttpServletRequest request) {
        List<UniteBean> beans = uniteService.findAllUnites();

        return new ResponseEntity<List<UniteBean>>(beans, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<UniteBean> createUnite(HttpSession session, @RequestBody UniteBean bean,
            HttpServletRequest request) {
        uniteService.createUnite(bean);

        return new ResponseEntity<UniteBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCreateUnite(HttpSession session,
            HttpServletRequest request) {
        UniteBean bean = new UniteBean();

        return new ModelAndView("/", "bean", bean);
    }

    @RequestMapping(value = "/update/{idUnite}", method = RequestMethod.POST)
    public ResponseEntity<UniteBean> updateUnite(HttpSession session, @RequestBody UniteBean bean,
            @PathVariable Integer idUnite, HttpServletRequest request) {
        uniteService.updateUnite(idUnite, bean);

        return new ResponseEntity<UniteBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{idUnite}", method = RequestMethod.GET)
    public ModelAndView showUpdateUnite(HttpSession session,
            @PathVariable Integer idUnite, HttpServletRequest request) {
        UniteBean bean = uniteService.findUnite(idUnite);

        return new ModelAndView("/", "bean", bean);
    }

    @RequestMapping(value = "/find/{idUnite}", method = RequestMethod.GET)
    public ResponseEntity<UniteBean> findUnite(HttpSession session, @PathVariable Integer idUnite,
            HttpServletRequest request) {
        UniteBean bean = uniteService.findUnite(idUnite);

        return new ResponseEntity<UniteBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idUnite}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeUnite(HttpSession session, @PathVariable Integer idUnite,
            HttpServletRequest request) {
        uniteService.removeUnite(idUnite);
    }
}
