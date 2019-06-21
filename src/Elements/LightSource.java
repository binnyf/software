/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 *
 * @author Binyamin
 */
public interface LightSource {
    
    public Color getIntensity(Point3D p);
    public Vector getL(Point3D p);
}