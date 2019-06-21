/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 *
 * @author Binyamin
 */
public class Plane extends Geometry {
    private Point3D p1;
    private Point3D p2;
    private Point3D p3;
    Vector normal;
    
    //default constuctor
    public Plane(){
        p1= new Point3D();
        p2= new Point3D();
        p3= new Point3D(); 
        normal=new Vector();
        material= new Material();
        emission=new Color(0,0,0);

    }
    
    //copy constructor
    public Plane(Plane P){
        this.p1=P.p1;
        this.p2=P.p2;
        this.p3=P.p3;
        material=P.material;
        emission=P.emission;
        normal=normal(p1);
    }
    
    //  variable constructor
    public Plane(Point3D a, Point3D b, Point3D c, Material m, Color e){
        this.p1=a;
        this.p2=b;
        this.p3=c;
        material =m;
        emission=e;
        normal=normal(a);
    }
    //p getter    
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
    public Vector normal(Point3D p){
        return new Vector(p2.subtract(p1)).crossProduct(new Vector(p3.subtract(p1))).normal();
	}
   
    
    //end of normal

    @Override
    public List<Point3D> findIntersections(Ray ray){
		//Initializes an empty list that will contain the point(s) of intersection, if any
	List<Point3D> listToReturn = new ArrayList<>();

	//denominator holds the result of the dot product between the ray and the plane
	double denominator = normal.dotProduct(ray.directionGetter());

		//if the dot product returns zero it means the ray is perpendicular to the normal which is perpendicular to the plane and therefore runs parallel to the plane and does not intersect
		if(denominator == 0) {
			//returns an empty list of intersection
			return listToReturn;
		}

		//t holds the distance from the source of the ray (camera) to the plane
		double t = (new Vector(p1.subtract(ray.POOgetter())).dotProduct(normal))/denominator;

		//We scale the Ray by t to get the point of intersection of the ray and the plane
                Vector a =new Vector(ray.directionGetter());
                a.scale(t);
		Point3D intersectedPoint = new Point3D(ray.POOgetter().add(a));

		//we add the new point of intersection to our list
		listToReturn.add(intersectedPoint);

		//return the list of intersections
		return listToReturn;
	}
    //end of intersections


}