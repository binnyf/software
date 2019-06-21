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
import primitives.Material;


/**
 *
 * @author Binyamin
 */
public class Sphere extends RadialGeometry{
    private Point3D center;
    
    //default constructor
    public Sphere(){
        center = new Point3D();
        material=new Material();
        emission=new Color(0,0,0);
    }
    
    //copy constructor
    public Sphere(Sphere S){
        this.center = S.center;
        this.radiusSetter(S.radiusGetter());
        material=S.material;
        emission=S.emission;
    }
    
    // 2 variable constructor
    
    public Sphere (Point3D c, double r,Material m, Color e){
        center=c;
        this.radiusSetter(r);
        material=m;
        emission=e;
    }
    
    //center getter
    public Point3D centerGetter(){
        return new Point3D(center);
    }
    
    //center setter
    public void centerSetter(Point3D c){
        center =c;
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
        
    //sphere normal
    public Vector normal(Point3D p){
       Vector n= new Vector((p.subtract(center)));
       n.scale(p.distance(center));
       return n;
       
  //     Vector a = new Vector(center);
     //  Point3D b = p.subtract(a); // point - center
       //Vector v =new Vector(b); // find the vector from the origin
       //return v.normal(); //normalize the vector
    }
    //end of sphere normal
    
    public ArrayList<Point3D> findIntersections(Ray ray){

        ArrayList<Point3D> listToReturn = new ArrayList<>();
		
	Vector l = new Vector(center.subtract(new Point3D(0,0,0)));
		double tM = l.dotProduct(ray.directionGetter().normal());
		double d = Math.sqrt(l.length()*l.length() - tM*tM);
		
		if(d > radiusGetter()) {
			return new ArrayList<>();
		}
		
		double tH = Math.sqrt(radiusGetter()*radiusGetter()- d*d);
		double t1 = tM-tH;
		double t2 = tM+tH;
		
		if(t1 >0) {
                    Vector v1=new Vector(ray.directionGetter().normal());
                    v1.scale(t1);
			Point3D p1 = new Point3D().add(v1);
			listToReturn.add(p1);
		}
		
		if(t2 >0) {
                    Vector v2=new Vector(ray.directionGetter().normal());
                    v2.scale(t2);
			Point3D p2 = new Point3D().add(v2);
			listToReturn.add(p2);
		}
		
		return listToReturn;
	}
}