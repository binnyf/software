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
public class Material {
    double Kd;
    double Ks;
    int shiny;
    
    public Material(){
        Kd=0.0;
        Ks=0.0;
        shiny=0;
        
}
    public Material(double a, double b, int c){
        Kd=a;
        Ks=b;
        shiny=c;
    }
    public Material(Material m){
        Kd=m.Kd;
        Ks=m.Ks;
    }
    public double getKd(){
        return Kd;
    }
    public double getKs(){
        return Ks;
    }
    public int getShiny(){
        return shiny;
    }
    public void setKd(double k){
        Kd=k;
    }
    public void setKs(double k){
        Ks=k;
    }
    public void setShiny(int s){
        shiny=s;
    }
}