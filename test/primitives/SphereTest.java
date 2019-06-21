/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package primitives;

import geometries.Sphere;
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

    /**
     * Test of getMaterial method, of class Sphere.
     */




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitives;

import geometries.*;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.Random;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 *
 * @author Binyamin
 */
public class SphereTest {
    @Test
    public void testIntersections(){
        
        //test for one intersection
        Point3D center = new Point3D(0.0,0.0,0.0);
        double r= 1.0;
        Point3D p0 = new Point3D(0.0,0.0,1.0);
        Vector d = new Vector(0.0,0.0,1.0);
        Ray ray= new Ray(p0,d);       
        Sphere s = new Sphere(center,r,material,e);
        ArrayList<Point3D> intersections = s.findIntersections(ray);
        assertEquals("Failed under 1 intersection", 1, intersections.get(0).compareTo(new Point3D(0.0,0.0,1.0))); 
        assertEquals("Failed under 1 intersection", true, intersections.size()==1); // test for 1 intersection
        
        
        // test for no intersection
        r=1.0;
        p0=new Point3D(3.0,3.0,3.0);
        d=new Vector(0.0,0.0,1.0);
        Ray ray1= new Ray(p0,d);
        Sphere s1= new Sphere(center,r);
        ArrayList<Point3D> intersections1 = s1.findIntersections(ray1);
        assertEquals("Failed under no intersection", true, intersections1.isEmpty()); // test for no intersection
        
       //test for 2 intersections
       r=1.0;
       center= new Point3D(0.0,0.0,1.0);
       p0= new Point3D(-3.0,-3.0,-3.0);
       d= new Vector(1.0,1.0,1.0);
       Ray ray2 = new Ray(p0,d);
       Sphere s2 = new Sphere(center,r);
       ArrayList<Point3D> intersections2 = s2.findIntersections(ray2);
       assertEquals("Failed under 2 intersection", true, intersections.size()==2); // test for 2 intersection
       assertEquals("Test for 2 intersection", 1, intersections2.get(0).compareTo(new Point3D(0.66666666,0.666666666,0.6666666))); 
       assertEquals("Test for 2 intersection", 1, intersections2.get(1).compareTo(new Point3D(0.0,0.0,0.0))); 
        
       
       
       
        
    }
}
