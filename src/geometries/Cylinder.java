/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometries;

import java.awt.Color;
import java.util.List;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 *
 * @author Binyamin
 */
public class Cylinder extends RadialGeometry {
    private Point3D axisPoint;
    private Point3D axisDirection;
    
    //default constructor
    public Cylinder(){
        axisPoint=new Point3D();
        axisDirection= new Point3D();
    }
    //copy constructor
    public Cylinder(Cylinder c){
        this.axisPoint=c.axisPoint;
        this.axisDirection=c.axisDirection;
        this.radiusSetter(c.radiusGetter());
    }
    //3 variable constructor
    public Cylinder(Point3D p, Point3D d, double r){
        axisPoint=p;
        axisDirection=d;
        this.radiusSetter(r);
    }
    //direction getter
    public Point3D axisDirectionGetter(){
        return new Point3D(axisDirection);
    }
    //point getter
    public Point3D axisPointGetter(){
        return new Point3D(axisPoint);
    }
    //direction setter
    public void axisDirectionSetter(Point3D d){
        axisDirection =d;
    }
    // point setter
    public void axisPointSetter(Point3D p){
        axisPoint =p;
    }

    @Override
    public Vector normal(Point3D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Point3D> findIntersections(Ray r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getEmission() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Material getMaterial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}