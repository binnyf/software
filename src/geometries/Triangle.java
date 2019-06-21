/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometries;

import java.awt.Color;
import java.util.ArrayList;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import java.lang.Math;
import java.util.List;
import primitives.Material;

/**
 *
 * @author Binyamin
 */
public class Triangle extends Geometry {
    private Point3D p1; // the three points of the triangle
    private Point3D p2;
    private Point3D p3;
    
    //default constuctor
    public Triangle(){
        p1= new Point3D();
        p2= new Point3D();
        p3= new Point3D();       
        material=new Material();
        emission=new Color(0,0,0);
    }
    
    //copy constructor
    public Triangle(Triangle T){
        this.p1=T.p1;
        this.p2=T.p2;
        this.p3=T.p3;
        material=T.material;
        emission=T.emission;
    }
    
    // 3 variable constructor
    public Triangle(Point3D a, Point3D b, Point3D c, Material m, Color e){
        this.p1=a;
        this.p2=b;
        this.p3=c;
        material=m;
        emission=e;
    }
    //p1 getter    
    public Point3D p1Getter(){
        return new Point3D(p1);
    } 
    
     //p2 getter    
    public Point3D p2Getter(){
        return new Point3D(p2);
    } 
    
      //p3 getter    
    public Point3D p3Getter(){
        return new Point3D(p3);
    } 
    //p1 setter
    public void p1Setter(Point3D a){
        p1=a;
    }
       //p2 setter
    public void p2Setter(Point3D b){
        p2=b;
    }
       //p3 setter
    public void p3Setter(Point3D c){
        p3=c;
    }
        //material getter
    public Material getMaterial() {
	return new Material(material);

    }
    //emission getter    
    public Color getEmission(){
        return new Color(emission.getRGB());
    }
    //material setter
    public void setMaterial(Material m){
        material=m;
    }
    //emission setter
    public void setEmission(Color e){
        emission=e;
    }
    
    public Vector normal(){ // find the normal of the triangle
       Vector P1= new Vector(p1); //Make P1 a vector
       Vector P2 =new Vector(p2); //Make P2 a vector
       Vector P3=new Vector(p3); //Make P3 a vector
       Vector a =new Vector(P1.subtract(P2)); // a=p1-p2
       Vector b=new Vector(P1.subtract(P3)); //b=p1-p3
       
       Point3D newHead=new Point3D(); //create new Head for the new Vector
        
       newHead.getCoordinateX().setC(a.dotProduct(P2)*b.dotProduct(P3)-(a.dotProduct(P3)*b.dotProduct(P2))); // find x value
       newHead.getCoordinateY().setC(a.dotProduct(P3)*b.dotProduct(P1)-(a.dotProduct(P1)*b.dotProduct(P3))); //find y value
       newHead.getCoordinateZ().setC(a.dotProduct(P1)*b.dotProduct(P2)-(a.dotProduct(P2)*b.dotProduct(P1))); //find z value

        
       return new Vector(newHead); // return the normal Vector
       
    }
    
   
public List<Point3D> findIntersections(Ray r) {
		//Initializes an empty list that will contain the point(s) of intersection, if any
		List<Point3D> listToReturn = new ArrayList<>();

		//Creates a plane representing the plane that the triangle lives in
		Plane planeEncompassingTriangle = new Plane(p1, p2, p3,material,emission);
		//Finds the point that the ray would intersect into that plane at
		List<Point3D> listOfPotentialPoints = planeEncompassingTriangle.findIntersections(r);
		//if it missed the plane entirely, it has no chance of hitting the triangle and we return an empty list
		if(listOfPotentialPoints.isEmpty()) {
			return listToReturn;
		}else { //otherwise we check the point using the formula given in class to see if it's in the triangle
			Point3D potentialPoint = listOfPotentialPoints.get(0);

			//Side 1

			Vector v11 = new Vector(p1);
			Vector v12 = new Vector(p2);
                        double magnitude1=Math.abs((v11.crossProduct(v12).length()));
                        Vector n1= new Vector(v11.crossProduct(v12));    
                        n1.scale(1/magnitude1);
			//Since there's no easy way to pull the sign, we divide the dot product by its absolute value, yielding us either 1 or -1, 
			//depending if it was positive or negative to begin with, respectively
			double sign1 = ((new Vector(potentialPoint)).subtract(new Vector()).dotProduct(n1))/Math.abs(((new Vector(potentialPoint)).subtract(new Vector()).dotProduct(n1)));

			//Side 2
			Vector v21 = new Vector(p2);
			Vector v22 = new Vector(p3);
                        double magnitude2=Math.abs((v21.crossProduct(v22).length()));
                        Vector n2= new Vector(v21.crossProduct(v22));    
                        n2.scale(1/magnitude2);
			//Since there's no easy way to pull the sign, we divide the dot product by its absolute value, yielding us either 1 or -1, 
			//depending if it was positive or negative to begin with, respectively
			double sign2 = ((new Vector(potentialPoint)).subtract(new Vector()).dotProduct(n2))/Math.abs(((new Vector(potentialPoint)).subtract(new Vector()).dotProduct(n2)));

			//Side 3
			Vector v31 = new Vector(p3);
			Vector v32 = new Vector(p1);
                        double magnitude3=Math.abs((v31.crossProduct(v32).length()));
                        Vector n3= new Vector(v31.crossProduct(v32));    
                        n3.scale(1/magnitude3);
			//Since there's no easy way to pull the sign, we divide the dot product by its absolute value, yielding us either 1 or -1, 
			//depending if it was positive or negative to begin with, respectively
			double sign3 = ((new Vector(potentialPoint)).subtract(new Vector()).dotProduct(n3))/Math.abs(((new Vector(potentialPoint)).subtract(new Vector()).dotProduct(n3)));

			//if it is, add it to the list
			if(sign1 == sign2 && sign2 == sign3) {
				listToReturn.add(potentialPoint);
			}

			//And return the list, empty or otherwise
			return listToReturn;
		}
	}

    @Override
    public Vector normal(Point3D p) {
        return new Plane(p1,p2,p3,material,emission).normal(p);
    }
}