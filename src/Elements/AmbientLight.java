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
public class AmbientLight extends Light{ //inherents from abstract class 'Light'
    private double Ka;
    
    //default constructor
    public AmbientLight(){
        color=new Color(0,0,0);
        Ka=0.0;
    }
    //end of default constructor
    
    //variable constructor
    public AmbientLight(Color c, double ka)
    {
        color = c;
        Ka = ka;
    }
    //end of variable constructor
    
    //getters and setters
    public Color getColor(){
        return new Color(color.getRGB());
    }
    
    public Double getKa(){
        return new Double(Ka);
    }
    
    public void setKa(double d){
        Ka=d;
    }
    
    public void setColor(Color c){
        color=c;
    }
    //end of getters and setters
    
    //getIntensity() determines the color of the geometry
       public Color getIntensity(Point3D p) //overrides the method from "Light"
   {
        int r= color.getRed();
        r*=Ka;
        int b = color.getBlue();
        b*=Ka;
        int g = color.getGreen();
        g*=Ka;
        return new Color(r,b,g);
    }
    //end of getIntensity()    



}