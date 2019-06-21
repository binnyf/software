package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;
import Elements.pointLight;

public class spotLight extends pointLight{
    //direction of the spotlight lighting
    Vector direction;

    //constructor which accepts a vector as a parameter and sets the direction of the spotlight accordingly
        //default constructor which creates a default vector as the direction of the spotlight
    
    public spotLight(){
        direction = new Vector();
    }
    public spotLight(Point3D p, Vector d, Color c, double kA){
    	position = p;
        direction = d.normal();
        color = c;
        Ka=kA;
        
    }
    
    public spotLight(Point3D p, Vector d){
    	position = p;
        direction = d.normal();
        color = new Color(255, 255, 255);
        Ka = 1.0;
    }
    
    public spotLight(Vector d){
    	position = new Point3D();
        direction = d.normal();
        color = new Color(255, 255, 255);
        Ka = 1.0;
    }


    //getter for the direction of the spotlight
    public Vector getdirection() {
        return direction;
    }
    
    //getter for the color of the spotlight
    public Color getColor() {
    	return new Color(color.getRGB());
    }

    //setter for the direction of the spotlight
    public void setdirection(Vector d) {
        direction = d;
    }
    
	public Color getIntensity(Point3D point) {
		double d = position.distance(point);
		double factor = (direction.dotProduct(getL(point))) / (Kc + Kl*d + Kq*d*d);
		return scaleColor(getColor(), factor);
	}

	public Vector getL(Point3D point) {
		return new Vector(point.subtract(position)).normal();
	}
	
	public Color scaleColor(Color color, double factor) {
		int newRed = ((int)(color.getRed()*factor) <= 255 ? (int)(color.getRed()*factor) : 255);
		newRed = (newRed >= 0 ? newRed : 0);
		int newGreen = ((int)(color.getGreen()*factor) <= 255 ? (int)(color.getGreen()*factor) : 255);
		newGreen = (newGreen >= 0 ? newGreen : 0);
		int newBlue = ((int)(color.getBlue()*factor) <= 255 ? (int)(color.getBlue()*factor) : 255);
		newBlue = (newBlue >= 0 ? newBlue : 0);
		
		return new Color(newRed, newGreen, newBlue);
	}

}
//hey