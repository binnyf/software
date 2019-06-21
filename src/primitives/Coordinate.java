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

//Coordinate Class
public class Coordinate {
    private double c; // A coordinate is a double
    
    
    //default constructor
    public Coordinate(){
        c = 0.0; //default c is 0
    }
    //end default constructor 
    
    // 1 variable constructor
    public Coordinate(double a){
       c= a; //assign coordinate c
    }
    //end of 1 variable constructor
    
    
    //copy constructor
    public Coordinate(Coordinate a){
        c = a.c;
    }
    //end of copy constructor
    
  
    //setter
    public void setC(double a){
        this.c = a; //set the value of c
    }
    //end of setter
    
    //getter
    public double getC(){
        return c; 
    }
    //end of getter
    
    public int compareTo(Coordinate a){
        if((a.getC()-this.getC()>-0.000001) && a.getC()-this.getC()<0.000001){ // if they are equal to enough sig figu
            return 1;
        }
        else return 0; // if they are unequal
 
    }
    // end of compare
    public Coordinate add(Coordinate C){
        double a= C.c+this.c; //add values
        return new Coordinate(a);
    }
    //end add
    
    public Coordinate subtract(Coordinate C){
        double a= this.c-C.c; //subtract values
        return new Coordinate(a);
    }
    //end subtract
}