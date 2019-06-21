/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 *
 * @author Binyamin
 */
public class Camera {
    private Point3D P0;
    private Vector up;
    private Vector to;
    private Vector right;
    
    //default constructor
    public Camera(){
        P0= new Point3D();
        up= new Vector();
        to = new Vector();
        right= new Vector();
        
    }
    // 4 variable constructor
    public Camera(Point3D p, Vector u, Vector t, Vector r){
        P0=p;
        up=u;
        to=t;
        right=r;
    }
    //copy constructor
    public Camera(Camera c){
        P0=c.P0;
        up=c.up;
        right=c.right;
        to=c.right;
    }
    // P0 getter
    public Point3D P0Getter(){
        return P0;
    }
    // up Getter
    public Vector upGetter(){
        return up;
    }
    // right Getter
        public Vector rightGetter(){
        return right;
    }
    //to Getter
        public Vector toGetter(){
        return to;
    }
    //P0 Setter
        public void P0setter(Point3D p){
            P0=p;
        }
     // up Setter
        public void upSetter(Vector u){
            up=u;
        }
     // right Setter
        public void rightSetter(Vector r){
            right=r;
        }
     // to Setter
        public void toSetter(Vector t){
            to=t;
        }
    // Contstruct a Ray from a Pixel
        public Ray constructRayThroughPixel (int Nx, int Ny,double x, double y, double screenDistance, double screenWidth, double screenHeight){
        up.scale(screenDistance); // scale the up vector by screendistance
        Point3D Pc= new Point3D(P0.add(up)); // find the centre Point
        right=to.crossProduct(up); // right is the crossproduct of up and to
        double Rx = screenWidth/Nx; // Find the ratio of width/number of x pixels
        double Ry = screenHeight/Ny; // find the ration of height/number of y pixels
        double scaleX = (((x-Nx/2)*Rx)+Rx/2); // find the scalar values
        double scaleY = (((y-Ny/2)*Ry)+Ry/2);
        right.scale(scaleX); //scale the right
        up.scale(scaleY); //scale the up
        Ray P = new Ray(Pc,right.subtract(up)); //create the Ray
        return P; //return the Ray
        
        }

}