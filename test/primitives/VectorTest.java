/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package primitives;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Binyamin
 *
public class VectorTest {
    
    
    public Vector createVector(double A, double B, double C){
    Coordinate a = new Coordinate (A);
    Coordinate b = new Coordinate (B);
    Coordinate c = new Coordinate (C);
    Point3D p = new Point3D(a,b,c);
    Vector v= new Vector(p);
    return v;
        }

@Test
public void testNormal(){
Point3D p1= new Point3D(new Coordinate(3.5), new Coordinate(-5.0),new Coordinate(10.0));
Vector v = new Vector(p1);
v.normal();
Point3D p2= new Point3D(new Coordinate(0.0), new Coordinate(0.0),new Coordinate(0.0));
assertEquals("", 1, v.length(),1e-10);
v = new Vector(p2);
try {
v.normal();
fail("Didn't throw divide by zero exception!");
} catch (ArithmeticException e) {
assertTrue(true);
}
*/
package primitives;

import primitives.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.Random;

public class VectorTest {

	@Test
	public void testAdd() {
		Vector v = new Vector(2.5, 3.6, 1.0);
		Vector newV = v.addition(new Vector(1.0, 1.0, 1.0));

        	assertEquals("Failed under positive addition", 1, newV.compareTo(new Vector(3.5, 4.6, 2.0)));
		// assertEquals("X coordinate failed under positive addition", 3.5,
		// newV.getHead().getX().getCoordinate(), 1e-10);
		// assertEquals("Y coordinate failed under positive addition", 4.6,
		// newV.getHead().getY().getCoordinate(), 1e-10);
		// assertEquals("Z coordinate failed under positive addition", 2.0,
		// newV.getHead().getZ().getCoordinate(), 1e-10);

		newV = v.addition(new Vector(-1.0, -1.0, -1.0));

		assertEquals("Failed under negative addition", 1, newV.compareTo(new Vector(1.5, 2.6, 0.0)));
		// assertEquals("X coordinate failed under negative addition", 1.5,
		// newV.getHead().getX().getCoordinate(), 1e-10);
		// assertEquals("Y coordinate failed under negative addition", 2.6,
		// newV.getHead().getY().getCoordinate(), 1e-10);
		// assertEquals("Z coordinate failed under negative addition", 0.0,
		// newV.getHead().getZ().getCoordinate(), 1e-10);

		newV = v.addition(new Vector(0.0, 0.0, 0.0));

		assertEquals("Failed under zero addition", 1, newV.compareTo(new Vector(2.5, 3.6, 1.0)));
		// assertEquals("X coordinate failed under zero addition", 2.5,
		// newV.getHead().getX().getCoordinate(), 1e-10);
		// assertEquals("Y coordinate failed under zero addition", 3.6,
		// newV.getHead().getY().getCoordinate(), 1e-10);
		// assertEquals("Z coordinate failed under zero addition", 1.0,
		// newV.getHead().getZ().getCoordinate(), 1e-10);

	}

	@Test
	public void testSubtract() {
		Vector v = new Vector(2.5, 3.6, 1.0);
		Vector newV = v.subtract(new Vector(1.0, 1.0, 1.0));

		assertEquals("Failed under positive subtraction", 1, newV.compareTo(new Vector(1.5, 2.6, 0.0)));
		// assertEquals("X coordinate failed under positive subtraction", 1.5,
		// newV.getHead().getX().getCoordinate(), 1e-10);
		// assertEquals("Y coordinate failed under positive subtraction", 2.6,
		// newV.getHead().getY().getCoordinate(), 1e-10);
		// assertEquals("Z coordinate failed under positive subtraction", 0.0,
		// newV.getHead().getZ().getCoordinate(), 1e-10);

		newV = v.subtract(new Vector(-1.0, -1.0, -1.0));

		assertEquals("Failed under negative subtraction", 1, newV.compareTo(new Vector(3.5, 4.6, 2.0)));
		// assertEquals("X coordinate failed under negative subtraction", 3.5,
		// newV.getHead().getX().getCoordinate(), 1e-10);
		// assertEquals("Y coordinate failed under negative subtraction", 4.6,
		// newV.getHead().getY().getCoordinate(), 1e-10);
		// assertEquals("Z coordinate failed under negative subtraction", 2.0,
		// newV.getHead().getZ().getCoordinate(), 1e-10);

		newV = v.subtract(new Vector(0.0, 0.0, 0.0));

		assertEquals("Failed under zero subtraction", 1, newV.compareTo(new Vector(2.5, 3.6, 1.0)));
		// assertEquals("X coordinate failed under zero subtraction", 2.5,
		// newV.getHead().getX().getCoordinate(), 1e-10);
		// assertEquals("Y coordinate failed under zero subtraction", 3.6,
		// newV.getHead().getY().getCoordinate(), 1e-10);
		// assertEquals("Z coordinate failed under zero subtraction", 1.0,
		// newV.getHead().getZ().getCoordinate(), 1e-10);

	}

	@Test
	public void testScaling() {
		Vector v = new Vector(7.7, 0.0, 0.032);
                v.scale(0.0);
                Vector newV= new Vector(v);

		assertEquals("Failed under scaling by zero", 0.0, newV.length(), 1e-10);
                
                v = new Vector(7.7, 0.0, 0.032);
		v.scale(-1.0);
                newV= new Vector(v);
 		assertEquals("Failed under vector reversal", 1, newV.compareTo(new Vector(-7.7, 0.0, -0.032)));
                
                v = new Vector(7.7, 0.0, 0.032);
		v.scale(2.0);
                newV= new Vector(v);
		assertEquals("Failed under stretching of vector", 1, newV.compareTo(new Vector(7.7 * 2.0, 0.0, 0.032 * 2.0)));
                
                v = new Vector(7.7, 0.0, 0.032);
		v.scale(0.5);
                newV= new Vector(v);
		assertEquals("Failed under shrinking of vector", 1, newV.compareTo(new Vector(7.7 / 2.0, 0.0, 0.032 / 2.0)));
	}

	@Test
	public void testDotProduct() {
		Vector v = new Vector(3.4, 5.6, 7.8);
		Vector newV = new Vector(0.9, 4.3, 2.1);

		assertEquals("Failed under normal dot product", 43.52, v.dotProduct(newV), 1e-10);

		newV = new Vector(-0.9, -4.3, -2.1);
		assertEquals("Failed under dot product with vector of opposing sign", -43.52, v.dotProduct(newV), 1e-10);

		newV = new Vector(0.0, 0.0, 0.0);
		assertEquals("Failed under dot product with zero vector", 0.0, v.dotProduct(newV), 1e-10);

		newV = new Vector(-11.9, 4.3, 2.1);
		assertEquals("Failed under dot product with orthogonal vector", 0, v.dotProduct(newV), 1e-10);
	}

	@Test
	public void testLength() {
		Vector v = new Vector(0.0, 0.0, 0.0);
		assertEquals("Zero vector length failed", 0.0, v.length(), 1e-10);

		v = new Vector(1.0, 0.0, -1.0);
		assertFalse("Assigned zero length to non-zero vector", v.length() == 0.0);

		Random r = new Random();
		double randomX = (r.nextDouble() * 200) - 100;
		double randomY = (r.nextDouble() * 200) - 100;
		double randomZ = (r.nextDouble() * 200) - 100;

		v = new Vector(randomX, randomY, randomZ);
		assertEquals("Length function failed on random vector",
				Math.sqrt(randomX * randomX + randomY * randomY + randomZ * randomZ), v.length(), 1e-10);

	}

	@Test
	public void testNormalize() {
		Vector v = new Vector(7.7, 0.0, 0.032);
		Vector newV = v.normal();

		assertEquals("Normalize failed", 1.0, newV.length(), 1e-10);
               /*
		v = new Vector(0.0, 0.0, 0.0);

		try {
			v.normal();
			fail("If it got to here then it didn't throw an error, which it should have.");
		} catch (IllegalArgumentException e) {
			assertEquals("Normalize threw the wrong error", e.getMessage(),
					"Cannot normalize the zero vector. Will result in divide by zero");
		}
                */
      

	}

	@Test
	public void testCrossProduct() {
		Vector v = new Vector(7.7, 0.0, 0.032);
		Vector zeroVector = new Vector(0.0, 0.0, 0.0);

		Vector newV = new Vector(3.85, 0.0, 0.016);
		assertTrue("Failed under cross product with parallel vector (scaled by 1/2)", v.crossProduct(newV).compareTo(zeroVector) == 1);

		newV = new Vector(-7.7, 0.0, -0.032);
		assertTrue("Failed under cross product with antiparallel vector (scaled by -1)", v.crossProduct(newV).compareTo(zeroVector) == 1);

		newV = new Vector(-0.032, 0.0, 7.7);
		assertEquals("X coordinate failed under cross product with orthogonal vector", 0.0, v.crossProduct(newV).headGetter().getCoordinateX().getC(), 1e-10);
		assertEquals("Y coordinate failed under cross product with orthogonal vector", -59.291024, v.crossProduct(newV).headGetter().getCoordinateY().getC(), 1e-10);
		assertEquals("Z coordinate failed under cross product with orthogonal vector", 0.0, v.crossProduct(newV).headGetter().getCoordinateZ().getC(), 1e-10);

		 newV = new Vector(-4.4, 5.6, 6.6);
		 assertEquals("X coordinate failed under cross product with random vector", -0.1792, v.crossProduct(newV).headGetter().getCoordinateX().getC(), 1e-10);
		 assertEquals("Y coordinate failed under cross product with random vector", -50.9608, v.crossProduct(newV).headGetter().getCoordinateY().getC(), 1e-10);
		 assertEquals("Z coordinate failed under cross product with random vector", 43.12, v.crossProduct(newV).headGetter().getCoordinateZ().getC(), 1e-10);
	}

}