/****************************************************************************************************
 * File name: SpriteFacade.java
 * Author: Todd Kelley, Saad Abdullah (040877175)
 * Course: CST8218 - Web Enterprise Application, Section: 300
 * Assignment: 1
 * Date: 2020 March 15
 * Professor: Todd Kelley
 * Purpose: Hides the implementation of the underlying classes it is presenting an interface for
 ****************************************************************************************************/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.abdu0397.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tgk
 */
@Stateless
public class SpriteFacade extends AbstractFacade<Sprite> {
    @PersistenceContext(unitName = "SpriteSaad-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SpriteFacade() {
        super(Sprite.class);
    }
    
}
