/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesServices;

import fr.imie.kitmeal.beans.AddressBean;
import java.util.List;

/**
 *
 * @author thomasberthe
 */
public interface IAddressService {

    public List<AddressBean> findAllAddress();

    public AddressBean createAddress(AddressBean bean);

    public AddressBean updateAddress(Integer idAddress, AddressBean bean);

    public AddressBean findAddress(Integer idAddress);

    public void removeAddress(Integer idAddress);
}
