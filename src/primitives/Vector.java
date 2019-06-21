 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitives;
import java.lang.Math;
import primitives.Point3D;
/**
 *
 * @author Binyamin
 */

//Vector class
public class Vector {
    private Point3D head; // the Head of the Vector as a Point3D
    
    //default constructor
    public Vector(){
      head = new Point3D();           
    }
    //copy constructor
    public Vector(Vector v){
       head=v.head;
    }
    //3 double constructor
    public Vector(double a, double b, double c){
        Coordinate A = new Coordinate(a); // assign x Coordinate
        Coordinate B = new Coordinate(b); // assign Y Coordinate
        Coordinate C = new Coordinate(c); //assign z Coordinate
        Point3D p = new Point3D(A,B,C); // Create new 3D Point to act as head of the vector
        head=p; //assign head of the vector
        
        
    }
    
    //1 variable constructor
    public Vector(Point3D p){
        head=p;
    }
    //head Getter
    public Point3D headGetter(){
        return this.head;
    }
    //Scaling for vector
    public void scale(double num){
        double a = head.getCoordinateX().getC(); //access x coordinate
        double b = head.getCoordinateY().getC(); //access y coordinate
        double c = head.getCoordinateZ().getC();//access z coordinate
        a = a * num; //scale the value of x coordinate  
        b = b * num; //scale the value of y coordinate
        c = c * num; //scale the value of z coordinate
        Vector v = new Vector(a,b,c); // change the value of the current vector to the new scaled vector
        head=v.head; // make our vector head the new scaled head
    }
    //End of Scaler for vector
    
   //Addition for vector
    public Vector addition(Vector v){
        double a = head.getCoordinateX().getC(); //access x coordinate
        a = a + v.head.getCoordinateX().getC(); //add the value of x coordinate
             
        double b = head.getCoordinateY().getC(); //access y coordinate
        b = b + v.head.getCoordinateY().getC(); //add the value of y coordinate

        double c = head.getCoordinateZ().getC();//access z coordinate
        c = c + v.head.getCoordinateZ().getC(); //add the value of z coordinate
                
        return new Vector(a,b,c); // return the new Vector that has been added
    }
    //End of Addition for vector
    
    //Subtraction for Vector
    public Vector subtract (Vector v){
        double a = head.getCoordinateX().getC(); //access x coordinate
        a = a - v.head.getCoordinateX().getC(); //subtract the value of x coordinate        
        
        double b = head.getCoordinateY().getC(); //access y coordinate
        b = b - v.head.getCoordinateY().getC(); //subtract the value of y coordinate
        
        double c = head.getCoordinateZ().getC();//access z coordinate
        c = c - v.head.getCoordinateZ().getC(); //subtract the value of z coordinate
        
        return new Vector(a,b,c); // return the new Vector with subtraction
    }
    //End of subtraction for Vector
    

    
    //Dot Product for vector
    public double dotProduct(Vector v){
        double a1 = head.getCoordinateX().getC(); //access x coordinates
        double a2 = v.head.getCoordinateX().getC();
        
        double b1 = head.getCoordinateY().getC(); //access y coordinates
        double b2 = v.head.getCoordinateY().getC(); 
               
        double c1 = head.getCoordinateZ().getC();//access z coordinates
        double c2 = v.head.getCoordinateZ().getC(); 
        
        return (a1*a2) + (b1*b2) + (c1*c2); // return the dot prodct
    }
    //End of dot product for vector
    
    //Cross Product for vector
    public Vector crossProduct(Vector v){

        double a1 = head.getCoordinateX().getC(); //access x coordinates
        double b1 = v.head.getCoordinateX().getC();
        
        double a2 = head.getCoordinateY().getC(); //access y coordinates
        double b2 = v.head.getCoordinateY().getC(); 
               
        double a3 = head.getCoordinateZ().getC();//access z coordinates
        double b3 = v.head.getCoordinateZ().getC(); 
        
        double x=(a2*b3) -(a3*b2); // do cross product calculations for x,y and z vector coordinates
        double y=(a3*b1)-(b3*a1);
        double z=(b2*a1)-(b1*a2);

              
        return new Vector(x,y,z); // return the new Cross Prodcut Vector
    }
    //End of cross product for vector
    
    //Magnitude of vector
    public double length(){
        double a = head.getCoordinateX().getC(); //access x coordinates       
        double b = head.getCoordinateY().getC(); //access y coordinates            
        double c = head.getCoordinateZ().getC();//access z coordinates

        return Math.sqrt(a*a +b*b +c*c); //return the square root of the sum of the squares
    }
    //end of length of vector
    
        public int compareTo(Vector a){
        if(a.head.getCoordinateX().compareTo(this.head.getCoordinateX())==1 && a.head.getCoordinateY().compareTo(this.head.getCoordinateY())==1 && a.head.getCoordinateZ().compareTo(this.head.getCoordinateZ())==1) // if all coordinates are equa
            return 1;
        else return 0; // if not equal
    }
      // end of compare
    
    //Normalize vector
    public Vector normal(){
        double a = head.getCoordinateX().getC()/this.length();
        double b = head.getCoordinateY().getC()/this.length();
        double c = head.getCoordinateZ().getC()/this.length();
       // String s = new String("Can't divide by Zero!");
     //   if(this.length()==0){
   //throw error
   //     }
        return new Vector(a,b,c); // return the new Vector
    }
}