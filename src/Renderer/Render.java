/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderer;

import Elements.LightSource;
import Elements.Scene;
import geometries.Geometry;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import java.lang.Math;

public class Render {
    private Scene scene;
    private ImageWriter imageWriter;
    
    //default constructor
    public Render(){
        scene=new Scene();
        imageWriter=new ImageWriter();
    }
    //end of default contructor
    
    //copy constructor
    public Render(Render r){
        scene=r.scene;
        imageWriter=r.imageWriter;
    }
    //end of copy constructor
    
    //variable constructor
    public Render(Scene s, ImageWriter i){
        scene=s;
        imageWriter=i;
    }
    //end of variable constructor
    
    //Renders the image from the intersection points
    public void RenderImage(){
        for(int i = 0; i < imageWriter.getWidth(); i++){ //traverse through the scene
            for(int j = 0; j < imageWriter.getHeight(); j++){
                Ray ray = scene.getCamera().constructRayThroughPixel(imageWriter.getWidth(), imageWriter.getHeight(),i,j, scene.getScreenDistance(), imageWriter.getNx(), imageWriter.getNy());//define a ray
                Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersectionPoints(ray); //find where the ray intersects the geometries
                if (intersectionPoints.isEmpty()){ //no intersection points     
                    imageWriter.writePixel(j, i, scene.getBackground()); //render and empty scene
                }
                else {
                    Map<Geometry, Point3D> closestPointMap = getClosestPoint(intersectionPoints); //find closest intersection
                    Geometry closestGeometry=(Geometry)closestPointMap.keySet().toArray()[0]; //assign geometry to that cosest point
                    Point3D closestPoint = (Point3D) closestPointMap.values().toArray()[0];
		    imageWriter.writePixel(i, j, calcColor(closestGeometry, closestPoint)); //"writes" the closest point to the geometry

                }
            }
        }
    }
    //end of RenderImage
    
    //Calculates the Illumination/color from the different lights
   /*private Color calcColor(Geometry geometry, Point3D p){
        Color ambientLight = scene.getAmbient().getIntensity(); //natural light of geometry
        Color emissionLight=geometry.getEmission(); //light that bounces off the geometry
        Color color = new Color((ambientLight.getRed() + emissionLight.getRed())/2,(ambientLight.getGreen() + emissionLight.getGreen())/2,(ambientLight.getBlue() + emissionLight.getBlue())/2); //equation for calculating the color
        return color;
    }
*/
    private Color calcColor(Geometry geometry, Point3D point){
        int numberOfLights = scene.getLightsList().size();
        Color ambientLight = scene.getAmbient().getIntensity(point);
        Color emissionLight = geometry.getEmission();

        int difR=0; //initialise the colors of the lights to 0
        int difG=0;
        int difB=0;
        int speR=0;
        int speG=0;
        int speB=0;

        Iterator<LightSource> lights = scene.getLightsIterator();
        while (lights.hasNext()){

            LightSource light=lights.next();

            //Check to make sure the reflected light would actually make it to the camera (It's not on the other side of a Geometry)
            if(Math.signum(light.getL(point).dotProduct(geometry.normal(point))) != Math.signum(new Vector(scene.getCamera().P0Getter().subtract(point)).dotProduct(geometry.normal(point)))) {
                //Checks to see if the point would even get hit by the LightSource (ie that it isn't in the shadow of something else)
                //Creates a new Ray starting at the point in question with a direction opposite the L from the light to the point (going back to the light)
                Ray rayBackToLight = new Ray(point, new Vector(light.getL(point)).scale(-1).normal());
                //Adjusts its source a little bit so a geometry doesn't block itself (sliding it up the vector a little closer to the light)
                rayBackToLight.setSource(rayBackToLight.POOgetter().add(rayBackToLight.directionGetter().scale(.0000001)));
                //Checks to see if there's any other geometry along the path
                Map<Geometry, List<Point3D>> geometriesBlockingLight = getSceneRayIntersectionPoints(rayBackToLight);

                //if there is no geometry blocking the light and causing a shadow
                if(geometriesBlockingLight.isEmpty()) {
                    //calculates the diffused light
                    Color dif =light.getIntensity(point); //find the intensity
                    double d =geometry.normal(point).dotProduct(light.getL(point)); //calculate the dot product
                    int k=(int) (geometry.getMaterial().getKd()*d); //caluclate the scalar
                    difR+=k*dif.getRed();// add the red from the difusion
                    difG+=k*dif.getGreen(); //add the green
                    difB+=k*dif.getBlue(); //add the blue

                    double x=2*light.getL(point).dotProduct(geometry.normal(point));
                    Vector a =geometry.normal(point);
                    a.scale(x);
                    Vector R = light.getL(point).subtract(a); //calculate R
                    //calculate specular light
                    int x1= (int) R.dotProduct(new Vector(scene.getCamera().P0Getter()));
                    int x2= (int) Math.pow(x1,geometry.getMaterial().getShiny());
                    x2*=geometry.getMaterial().getKs();
                    speR+=x2*dif.getRed();
                    speG+=x2*dif.getGreen();
                    speB+=x2*dif.getBlue();

                    //Return color with Diffusion Light and Specular Light
                    Color diffuseLight=new Color(difR,difG,difB);
                    Color specularLight=new Color(speR,speG,speB);
                    return new Color(ambientLight.getRed()+emissionLight.getRed()+diffuseLight.getRed()+specularLight.getRed(),// add the reds
                    ambientLight.getGreen()+emissionLight.getGreen()+diffuseLight.getGreen()+specularLight.getGreen(), //add the greens
                    ambientLight.getBlue()+emissionLight.getBlue()+diffuseLight.getBlue()+specularLight.getGreen()); //add the blues
                }
            }
            
        }
        return null;
    }
    

    //end of calcColor
    
    
    //FInds where the a given Ray intersects our scene 
    private Map<Geometry,List<Point3D>> getSceneRayIntersectionPoints(Ray ray){   
            Iterator<Geometry> geometries = scene.getGeometryIterator(); //create iterator to traverse the geometries
            Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();//createamap of intersection points
            while (geometries.hasNext()){ //go through all geometries
                Geometry geometry = geometries.next();
                List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);//add all intersection points to the list
                if(!geometryIntersectionPoints.isEmpty()){
                intersectionPoints.put(geometry,geometryIntersectionPoints);
            }
        }
         return intersectionPoints;
    }
    //end of gerRayIntersectionPoints


    //Find closest point to geometry       
    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> map) { 

        double distance = Double.MAX_VALUE; //distace between the scene and geometry
        Map<Geometry, Point3D> closestPoint = new HashMap<Geometry, Point3D>();

        for (Geometry geometry: map.keySet()){
            for(Point3D point:map.get(geometry)){
                if (scene.getCamera().P0Getter().distance(point)<distance){
                    distance = scene.getCamera().P0Getter().distance(point); //assigns new closest distance
                    closestPoint.clear();
                    closestPoint.put(geometry, new Point3D(point));
                }
            }
        }
        return closestPoint;
    }
    //end of getClosestPoint
    
    
    // private method to calculate the diffuse light (according to the formula from slides)
    private Color calcDiffuseComp(Double kd, Vector normal, Vector l, Color intensity) {
            double factor = Math.abs(kd*(normal.dotProduct(l)));
            return scaleColor(intensity, factor);
    }

    // private method to calculate the specular light (according to the formula from slides)
    private Color calcSpecularComp(Double ks, Vector v, Vector normal, Vector l, int shininess, Color intensity) {
            Vector r;
            r = l.subtract(normal.scale(2*l.dotProduct(normal)));
            double factor = ks*Math.abs(Math.pow(v.normal().dotProduct(r.normal()), shininess));
            return scaleColor(intensity, factor);
    }

    //Helper method to scale colors properly without going out of range
    public static Color scaleColor(Color color, double factor) {
            int newRed = ((int)(color.getRed()*factor) <= 255 ? (int)(color.getRed()*factor) : 255);
            newRed = (newRed >= 0 ? newRed : 0);
            int newGreen = ((int)(color.getGreen()*factor) <= 255 ? (int)(color.getGreen()*factor) : 255);
            newGreen = (newGreen >= 0 ? newGreen : 0);
            int newBlue = ((int)(color.getBlue()*factor) <= 255 ? (int)(color.getBlue()*factor) : 255);
            newBlue = (newBlue >= 0 ? newBlue : 0);

            return new Color(newRed, newGreen, newBlue);
    }
}