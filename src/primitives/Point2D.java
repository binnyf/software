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
public class Point2D {
    private Coordinate x; // Coordinate in the x plane
    private Coordinate y; // Coordinate in the y plane
    
    //default constructor
    public Point2D(){
        this.x=new Coordinate(0.0);//Set x as 0
        this.y=new Coordinate(0.0);//set y as 0

 
    }
    //end default constructor 
    
    // 2 variable constructor
    public Point2D(double X, double Y){
        x.setC(X); //set X to x coordinate
        y.setC(Y); //set Y to y coordinate
    }
    //end 2 variable constructor
    
    
    //copy constructor
    public Point2D(Point2D c){
        x = c.x; //copy the x value
        y = c.y; //copy the y vaue
    }
    //end of copy constructor
    
  
    //setter for x
    public void setCoordinateX(Coordinate X){
        x = X; //set the value of x
    }
    //end of setter for x
    
        //setter for x
    public void setCoordinateY(Coordinate Y){
        y = Y; //set the value of y
    }
    //end of setter for y
 
    //getter for x
    public Coordinate getCoordinateX(){
        return new Coordinate(x);
    }
    //end of getter
    
    //getter for y
    public Coordinate getCoordinateY(){
        return new Coordinate(y);
    }
    public int compareTo(Point2D a){
        if(a.getCoordinateX().compareTo(this.x)==1 && a.getCoordinateY().compareTo(this.y)==1) // if both coordinates are equal
            return 1;
        else return 0; // if the point is not equal
      
     }
      // end of compare
    

}