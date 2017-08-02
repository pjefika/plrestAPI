/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.entities.Ionix;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0041775
 */
public class IonixAbertosDAOIT {
    
    public IonixAbertosDAOIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAbertos method, of class IonixAbertosDAO.
     */
    @Test
    public void testGetAbertos() {
        System.out.println("getAbertos");
        IonixAbertosDAO instance = new IonixAbertosDAO();
        List<Ionix> result = instance.getAbertos();
        assertTrue(!result.isEmpty());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
