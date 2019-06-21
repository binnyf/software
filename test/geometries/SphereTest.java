/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometries;

import java.awt.Color;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 *
 * @author joshl813
 */
public class SphereTest {
    
    public SphereTest() {
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
     * Test of centerGetter method, of class Sphere.
     */
    @Test
    public void testCenterGetter() {
        System.out.println("centerGetter");
        Sphere instance = new Sphere();
        Point3D expResult = null;
        Point3D result = instance.centerGetter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of centerSetter method, of class Sphere.
     */
    @Test
    public void testCenterSetter() {
        System.out.println("centerSetter");
        Point3D c = null;
        Sphere instance = new Sphere();
        instance.centerSetter(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaterial method, of class Sphere.
     */
    @Test
    public void testGetMaterial() {
        System.out.println("getMaterial");
        Sphere instance = new Sphere();
        Material expResult = null;
        Material result = instance.getMaterial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmission method, of class Sphere.
     */
    @Test
    public void testGetEmission() {
        System.out.println("getEmission");
        Sphere instance = new Sphere();
        Color expResult = null;
        Color result = instance.getEmission();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaterial method, of class Sphere.
     */
    @Test
    public void testSetMaterial() {
        System.out.println("setMaterial");
        Material m = null;
        Sphere instance = new Sphere();
        instance.setMaterial(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmission method, of class Sphere.
     */
    @Test
    public void testSetEmission() {
        System.out.println("setEmission");
        Color e = null;
        Sphere instance = new Sphere();
        instance.setEmission(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of normal method, of class Sphere.
     */
    @Test
    public void testNormal() {
        System.out.println("normal");
        Point3D p = null;
        Sphere instance = new Sphere();
        Vector expResult = null;
        Vector result = instance.normal(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findIntersections method, of class Sphere.
     */
    @Test
    public void testFindIntersections() {
        System.out.println("findIntersections");
        Ray ray = null;
        Sphere instance = new Sphere();
        ArrayList<Point3D> expResult = null;
        ArrayList<Point3D> result = instance.findIntersections(ray);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
