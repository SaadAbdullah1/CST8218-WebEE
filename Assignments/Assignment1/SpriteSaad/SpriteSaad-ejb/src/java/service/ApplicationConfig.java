/****************************************************************************************************
 * File name: ApplicationConfig.java
 * Author: Todd Kelley, Saad Abdullah (040877175)
 * Course: CST8218 - Web Enterprise Application, Section: 300
 * Assignment: 1
 * Date: 2020 March 15
 * Professor: Todd Kelley
 * Purpose: Provides the configuration details for the application
 ****************************************************************************************************/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.annotation.security.RolesAllowed;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.ws.rs.core.Application;

/**
 *
 * @author Me
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "${'java:comp/DefaultDataSource'}",
        callerQuery = "#{'select password from app.appuser where userid = ?'}",
        groupsQuery = "select groupname from app.appuser where userid = ?",
        hashAlgorithm = PasswordHash.class,
        priority = 10
)
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.SpriteFacadeREST.class);
    }
    
}
