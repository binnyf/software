/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitives;

/**
 *
 * @author Binyamin
 */

public class Ray {
    private Point3D POO;
    private Vector direction;
    
    //default constructor
    public Ray(){
        POO=new Point3D();
        direction = new Vector();
    }
    //copy constructor
    public Ray(Ray r){
        this.POO=r.POO;
        this.direction=r.direction;
    }
    //2 variable constructor
    public Ray (Point3D p, Vector d){
        POO=p;
        direction =d;
    }
    //direction getter
    public Vector directionGetter(){
        return direction;
    }
    // POO getter
    public Point3D POOgetter(){
        return (POO);
    }
    // direction setter
    public void directionSetter(Vector v){
        direction =v;
    }
    //POO setter
    public void POOsetter(Point3D p){
        POO=p;
    }

    public int comapreTo(Ray ray) {
        if(ray.POO.compareTo(this.POOgetter())==1&& (ray.directionGetter().compareTo(this.directionGetter())==1)){
            return 1; // if not equal
        }
        else return 0;
    }
}