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
public abstract class Geometry {
    
    Material material;
    Color emission;

    public abstract List<Point3D> findIntersections(Ray ray);
    public abstract Vector normal(Point3D p);
    public abstract Color getEmission();
    public abstract Material getMaterial();
}