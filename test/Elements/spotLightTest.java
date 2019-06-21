/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import elements.spotLight;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import primitives.Point3D;
import primitives.Vector;

/**
 *
 * @author joshl813
 */
public class spotLightTest {
    
    public spotLightTest() {
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
     * Test of getdirection method, of class spotLight.
     */
    @Test
    public void testGetdirection() {
        System.out.println("getdirection");
        spotLight instance = new spotLight();
        Vector expResult = null;
        Vector result = instance.getdirection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class spotLight.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        spotLight instance = new spotLight();
        Color expResult = null;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setdirection method, of class spotLight.
     */
    @Test
    public void testSetdirection() {
        System.out.println("setdirection");
        Vector d = null;
        spotLight instance = new spotLight();
        instance.setdirection(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIntensity method, of class spotLight.
     */
    @Test
    public void testGetIntensity() {
        System.out.println("getIntensity");
        Point3D point = null;
        spotLight instance = new spotLight();
        Color expResult = null;
        Color result = instance.getIntensity(point);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getL method, of class spotLight.
     */
    @Test
    public void testGetL() {
        System.out.println("getL");
        Point3D point = null;
        spotLight instance = new spotLight();
        Vector expResult = null;
        Vector result = instance.getL(point);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scaleColor method, of class spotLight.
     */
    @Test
    public void testScaleColor() {
        System.out.println("scaleColor");
        Color color = null;
        double factor = 0.0;
        spotLight instance = new spotLight();
        Color expResult = null;
        Color result = instance.scaleColor(color, factor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
