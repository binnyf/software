/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometries;

import java.util.List;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 *
 * @author Binyamin
 */
public abstract class RadialGeometry extends Geometry {
    private double radius;
    
    //default constructor
    public RadialGeometry(){
        radius=0;
    }
    //copy constuctor
    public RadialGeometry(RadialGeometry r){
        this.radius=r.radius;
    }
    //1 variable constructor
    public RadialGeometry(double r){
        radius=r;
    }
    //radius getter;
    public double radiusGetter(){
        return radius;
    }
    //radius setter
    public void radiusSetter(double r){
        radius =r;
    }
    public abstract Vector normal(Point3D p);
    
    public abstract List<Point3D> findIntersections (Ray r);
}