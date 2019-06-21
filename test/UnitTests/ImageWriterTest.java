/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import Elements.*;
import java.awt.Color;
import Renderer.ImageWriter;
import Renderer.Render;
import geometries.Geometry;
import geometries.Sphere;
import geometries.Triangle;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.Random;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/*
 *
 * @author Binyamin

public class ImageWriterTest {
   @Test
    
    public void test(){
        Color c = new Color(0,30,30);
        AmbientLight ambientLight= new AmbientLight();
        Point3D p1 = new Point3D(0.0,0.0,0.0);
        Point3D p2= new Point3D(2.0,0.0,0.0);
        Point3D p3= new Point3D (1.0,1.0,0.0);
        Triangle T1 = new Triangle(p1,p2,p3);
        ArrayList <Geometry> geometries = new ArrayList<>();
        geometries.add(T1);
        Camera cam =new Camera();
        double screenDistance =1.0;
        Scene scene=new Scene ("Scene1", c,ambientLight,geometries,cam,screenDistance);
        ImageWriter i=new ImageWriter("test",500,500,50,50);
        Render render=new Render(scene,i);
        render.RenderImage();
        i.writeToimage();
        
    }
    
    
}

 */
public class ImageWriterTest
{/*
    @Test
    public void writeImageTest()
    {
        ImageWriter imageWriter = new ImageWriter("test3GridImage", 500, 500, 500, 500);

        // create black background
        for (int i = 0; i < 500; i++)
        {
            for (int j = 0; j < 500; j++)
            {
                imageWriter.writePixel(i, j, Color.BLACK);
            }
        }

        // draw grid rows
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 500; j++)
            {
                imageWriter.writePixel(i * 50, j, Color.WHITE);
                imageWriter.writePixel(i * 50 + 49, j, Color.WHITE);
            }
        }

        // draw grid columns
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 500; j++)
            {
                imageWriter.writePixel(j, i * 50, Color.WHITE);
                imageWriter.writePixel(j, i * 50 + 49, Color.WHITE);
               
            }
        }

*/
    @Test 
	public void emmissionTest(){
		
		Scene scene = new Scene(); // create a new scene
                scene.setScreenDistance(50); //set the screendistance to 50
		
		scene.addGeometry(new Sphere( new Point3D(0.0, 0.0, -149),50,new Material(), new Color(255,0,0))); // add a sphere
		
                //add the 4 triangles
		Triangle triangle = new Triangle(new Point3D( 100, 0, -149), 
				 						 new Point3D(  0, 100, -149),
				 						 new Point3D( 100, 100, -149), new Material(),
				 						 new Color(0,255,0));
		
		Triangle triangle2 = new Triangle(new Point3D( 100, 0, -149),
				 			 			  new Point3D(  0, -100, -149),
				 			 			  new Point3D( 100,-100, -149),new Material(),
					 						 new Color(0,0,255));
		
		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -149),
				 						  new Point3D(  0, 100, -149),
				 						  new Point3D(-100, 100, -149),new Material(),
				 						  new Color(255,255,0));
		
		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -149),
				 			 			  new Point3D(  0,  -100, -149),
				 			 			  new Point3D(-100, -100, -149),new Material(),
					 						 new Color(255,0,255));
		
		scene.addGeometry(triangle); //add the triangles to teh scene
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter("4 Triangles and Spheres", 500, 500, 500, 500); //create the file
		
		Render render = new Render(scene,imageWriter);
		
		render.RenderImage(); //render the image
		//render.printGrid(50);
		imageWriter.writeToimage(); // print the image
	}
}