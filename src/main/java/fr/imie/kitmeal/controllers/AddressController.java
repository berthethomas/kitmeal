/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.AddressBean;
import fr.imie.kitmeal.interfacesServices.IAddressService;
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
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    IAddressService addressService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AddressBean>> findAllAddresses(HttpSession session,
            HttpServletRequest request) {
        List<AddressBean> beans = addressService.findAllAddress();

        return new ResponseEntity<List<AddressBean>>(beans, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<AddressBean> createAddress(HttpSession session, @RequestBody AddressBean bean,
            HttpServletRequest request) {
        addressService.createAddress(bean);

        return new ResponseEntity<AddressBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCreateAddress(HttpSession session,
            HttpServletRequest request) {
        AddressBean bean = new AddressBean();

        return new ModelAndView("/", "bean", bean);
    }

    @RequestMapping(value = "/update/{idAddress}", method = RequestMethod.POST)
    public ResponseEntity<AddressBean> updateAddress(HttpSession session, @RequestBody AddressBean bean,
            @PathVariable Integer idAddress, HttpServletRequest request) {
        addressService.updateAddress(idAddress, bean);

        return new ResponseEntity<AddressBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{idAddress}", method = RequestMethod.GET)
    public ModelAndView showUpdateAddress(HttpSession session,
            @PathVariable Integer idAddress, HttpServletRequest request) {
        AddressBean bean = addressService.findAddress(idAddress);

        return new ModelAndView("/", "bean", bean);
    }

    @RequestMapping(value = "/find/{idAddress}", method = RequestMethod.GET)
    public ResponseEntity<AddressBean> findAddress(HttpSession session, @PathVariable Integer idAddress,
            HttpServletRequest request) {
        AddressBean bean = addressService.findAddress(idAddress);

        return new ResponseEntity<AddressBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idAddress}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeCategory(HttpSession session, @PathVariable Integer idAddress,
            HttpServletRequest request) {
        addressService.removeAddress(idAddress);
    }

}
