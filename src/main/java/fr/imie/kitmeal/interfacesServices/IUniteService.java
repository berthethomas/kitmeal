/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesServices;

import fr.imie.kitmeal.beans.UniteBean;
import java.util.List;

/**
 *
 * @author thomasberthe
 */
public interface IUniteService {

    public List<UniteBean> findAllUnites();

    public UniteBean createUnite(UniteBean bean);

    public UniteBean updateUnite(Integer idUnite, UniteBean bean);

    public UniteBean findUnite(Integer idUnite);

    public void removeUnite(Integer idUnite);
}
