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
public class Point3D extends Point2D{ // class inherits from Point2D
    private Coordinate z; // Coordinate in the z plane
    
    //default constructor
    public Point3D(){
        this.z=new Coordinate(0.0);
    }
    //end default constructor
    //3 double constructor
    public Point3D(double a, double b, double c){
        Coordinate A= new Coordinate(a);
        Coordinate B= new Coordinate(b);
        Coordinate C= new Coordinate(c);
        this.setCoordinateX(A);
        this.setCoordinateY(B);
        this.setCoordinateZ(C);
        
    }
    
    //3 variable constructor
    public Point3D(Coordinate X, Coordinate Y, Coordinate Z){
       this.setCoordinateX(X);
       this.setCoordinateY(Y);
       this.z=Z;
    }
    //end 3 variable constructor
    
    //copy constructor
    public Point3D(Point3D P){
      this.setCoordinateX(P.getCoordinateX());
      this.setCoordinateY(P.getCoordinateY());
      this.z=P.z;
    }
    //endcopy constructor
    
    //setter for z
    public void setCoordinateZ(Coordinate Z){
        z = Z; //set the value of y
    }
    //end of setter for z
 
    //getter for z
    public Coordinate getCoordinateZ(){
        return new Coordinate(z);
    }
    public int comapreTo(Point3D a){
        if(a.getCoordinateX().compareTo(this.getCoordinateX())==1 && a.getCoordinateY().compareTo(this.getCoordinateY())==1 && a.getCoordinateZ().compareTo(this.getCoordinateZ())==1) // if all coordinates are equa
            return 1;
        else return 0; // if not equal
    }
      // end of compare
    
    public Point3D add(Vector v){
        double a = this.getCoordinateX().getC(); //access x coordinate
        a = a + v.headGetter().getCoordinateX().getC(); //add the value of x coordinate     
        
        double b = this.getCoordinateY().getC(); //access y coordinate
        b = b + v.headGetter().getCoordinateY().getC(); //add the value of y coordinate
        
        double c = this.getCoordinateZ().getC();//access z coordinate
        c = c + v.headGetter().getCoordinateZ().getC(); //add the value of z coordinate
        
        return new Point3D(a,b,c); // return the new Point3D
    }
    //End of Addition for Point3D
    
        public Point3D subtract(Vector v){
        double a = this.getCoordinateX().getC(); //access x coordinate
        a = a - v.headGetter().getCoordinateX().getC(); //subtract the value of x coordinate
        
        double b = this.getCoordinateY().getC(); //access y coordinate
        b = b - v.headGetter().getCoordinateY().getC(); //subtract the value of y coordinate
        
        double c = this.getCoordinateZ().getC();//access z coordinate
        c = c - v.headGetter().getCoordinateZ().getC(); //subtract the value of z coordinate
       
        return new Point3D(a,b,c); // return the new Point3D
    }
            
        public Point3D subtract(Point3D v){
        double a = this.getCoordinateX().getC(); //access x coordinate
        a = a - v.getCoordinateX().getC(); //subtract the value of x coordinate
        
        double b = this.getCoordinateY().getC(); //access y coordinate
        b = b - v.getCoordinateY().getC(); //subtract the value of y coordinate
        
        double c = this.getCoordinateZ().getC();//access z coordinate
        c = c - v.getCoordinateZ().getC(); //subtract the value of z coordinate
       
        return new Point3D(a,b,c); // return the new Point3D
    }
    //End of subtraction for Point3D
        
        public double distance(Point3D p){
        double A= getCoordinateZ().getC()-(p.getCoordinateZ().getC());
        double B= getCoordinateY().getC()-p.getCoordinateY().getC();
        double C= getCoordinateX().getC()-p.getCoordinateX().getC();
        return Math.sqrt(A*A+B*B+C*C);
    }
}


