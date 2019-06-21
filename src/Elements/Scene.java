/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import geometries.Geometry;
import geometries.Triangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Binyamin
 */
public class Scene {
    private String sceneName;
    private Color background;
    private AmbientLight ambientLight;
    private List <Geometry> geometry; //a list of the geometries in the scene
    public List <LightSource> lights;
    private Camera camera;
    private double screenDistance;
    
   //variable constructor
   public Scene(String s, Color c, AmbientLight a, ArrayList<Geometry> g,ArrayList<LightSource> l, Camera cam, double sd){
       sceneName= s;
       background=c;
       ambientLight=a;
       lights=l;
       geometry=g;
       camera=cam;
       screenDistance=sd;
   }
   //end of variable constructor
    
  // default constructor
   public Scene(){
       sceneName=new String();
       background = new Color(0,0,0);
       ambientLight=new AmbientLight();
       geometry= new ArrayList<Geometry>();
       lights=new ArrayList<LightSource>();
       camera = new Camera();
       screenDistance=0.0;
   }    
   //end of default constructor
   
   //copy constructor
   public Scene(Scene a){
       sceneName=a.sceneName;
       background =a.background;
       ambientLight=a.ambientLight;
       geometry=a.geometry;
       lights=a.lights;
       camera=a.camera;
       screenDistance=a.screenDistance;
   }
   //end of copy constructor
   
   //getters
   public double getScreenDistance(){
       return screenDistance;
   }
    public AmbientLight getAmbient(){
        return ambientLight;
    }
  
    public Color getBackground(){
        return background;
    }
    public Camera getCamera(){
        return camera;
    }
    //end of getters
    
    public void addGeometry(Geometry g){ // add a new geometry to the list
        geometry.add(g); // add the geometry to the list
    }
    public Iterator<Geometry> getGeometryIterator(){
        return geometry.iterator(); // get the iterator for the list
    } 
      public Iterator<LightSource> getLightsIterator(){ //get the iterator for the lights
          return lights.iterator();
      }
      public void addLight(LightSource l){
          lights.add(l);
      }

    public void setScreenDistance(int i) {
        screenDistance=i;
    }

    
   public List<LightSource> getLightsList(){
   //Returns new List with the same values as our lights, so that changes made at the callsite wont affect our variables
	return new ArrayList<LightSource>(lights);
        
   }
}