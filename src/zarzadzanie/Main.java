/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zarzadzanie;

import encje.Pacjent;
import gui.MainJFrame;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;


/**
 *
 * @author Monika
 */
public class Main {
    
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static MainJFrame app;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        entityManagerFactory = Persistence.createEntityManagerFactory("SzpitalPU");
        entityManager = entityManagerFactory.createEntityManager();      
                
        app = new MainJFrame();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static MainJFrame getApp() {
        return app;
    }
}
