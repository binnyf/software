package Renderer;

import Elements.*;
import geometries.*;
import primitives.*;
import java.awt.Color;
import elements.spotLight;
import geometries.Geometry;
import geometries.Sphere;
import geometries.Triangle;
import java.util.ArrayList;
import org.junit.Test;






public class RenderTest {
	
	@Test
	public void renderTest() {
		//Sets up a "sun" with white light
		AmbientLight ambientLight = new AmbientLight(new Color(255, 255, 255), 1.0);
		//Sets up an empty list of lights
		ArrayList lights = new ArrayList<LightSource>();
		//Creates a spotlight to add to our scene
		spotLight s = new spotLight(new Point3D(10, -3, -5), new Vector(-1, 0, -1), new Color(255, 0, 0), 1);
		lights.add(s);
		//Creates a sphere and some triangles around it 
		Material material = new Material();
		Color emission = new Color(0,0,0);
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -10.0), 3.0, material, emission);
		
		Material material1 = new Material();
		Color emission1 = new Color(0, 255, 0);
		Material material2 = new Material();
		Color emission2 = new Color(0,0 ,0);
		Material material3 = new Material();
		Color emission3 = new Color(0,0,255);
		Material material4 = new Material();
		Color emission4 = new Color(255,0,0);
		
		Triangle triangle1 = new Triangle(new Point3D(-6.75, 6.75, -10), new Point3D(-6.75, 0, -10), new Point3D(0, 6.75, -10), material1, emission1);
		Triangle triangle2 = new Triangle(new Point3D(0, 6.75, -10), new Point3D(6.75, 6.75, -10), new Point3D(6.75, 0, -10), material2, emission2);
		Triangle triangle3 = new Triangle(new Point3D(6.75, 0, -10), new Point3D(6.75, -6.75, -10), new Point3D(0, -6.75, -10), material3, emission3);
		Triangle triangle4 = new Triangle(new Point3D(0, -6.75, -10), new Point3D(-6.75, -6.75, -10), new Point3D(-6.75, 0, -10), material4, emission4);
		//Creates a list of geometries to feed into our Scene instance
		ArrayList list = new ArrayList<Geometry>();
		//Adds the sphere and triangles to the list
		list.add(sphere);
		list.add(triangle1);
		list.add(triangle2);
		list.add(triangle3);
		list.add(triangle4);
		//Instantiates a new Camera with default values (point at the origin, facing down the negative z axis)
		Camera camera = new Camera();
		//Creates a scene to hold our universe
		Scene scene = new Scene("TestScene", new Color(0, 0, 0), ambientLight, lights, list, camera, 30.0);
		//Creates an ImageWriter instance to help write down what our camera sees
		ImageWriter imageWriter = new ImageWriter("RenderTestWithEmissionAndSpotlightRefectoredTest2", 500, 500, 100, 100);
		//Creates a Render instance to pull it all together
		Render render = new Render(scene, imageWriter);
		
		
		//Records what the camera sees
		render.RenderImage();

		//Prints it all to a file
		imageWriter.writeToimage();
		
	}

	@Test
	public void spotLightRenderTest() {
		//Sets up a "sun" with white light
		AmbientLight ambientLight = new AmbientLight(new Color(255, 255, 255), 1.0);
		//Instantiates a new Camera with default values (point at the origin, facing down the negative z axis)
		Camera camera = new Camera();
		//Sets up the list of geometries in our scene
		ArrayList geoList = new ArrayList<Geometry>();
		//Sets up the sphere in our scene and adds it to the list
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -10.0),6.0, new Material(3.0, 3.0, 100), new Color(148,0,211));
		geoList.add(sphere);
		//Sets up an empty list of lights
		ArrayList lights = new ArrayList<LightSource>();
		//Creates a spotlight to add to our scene
		spotLight sLight = new spotLight(new Point3D(-25,-25,-2), new Vector(-1,-1,-1.5), new Color(255,255,255),1);
		lights.add(sLight);
		//Creates a scene to hold it all
		Scene scene = new Scene("SpotLightTestScene", new Color(0,0,0), ambientLight, lights, geoList, camera, 30.0);
		//Creates an ImageWriter instance to help write down what our camera sees
		ImageWriter imageWriter = new ImageWriter("SpotLightTest3Refactored", 500, 500, 100, 100);
		//Creates a Render instance to pull it all together
		Render render = new Render(scene, imageWriter);


		//Records what the camera sees
		render.RenderImage();
		//Prints it all to a file
		imageWriter.writeToimage();
	}
	
	@Test
	public void pointLightRenderTest() {
		//Sets up a "sun" with white light
		AmbientLight ambientLight = new AmbientLight(new Color(255, 255, 255), 1.0);
		//Instantiates a new Camera with default values (point at the origin, facing down the negative z axis)
		Camera camera = new Camera();
		//Sets up the list of geometries in our scene
		ArrayList geoList = new ArrayList<Geometry>();
		//Sets up the sphere in our scene and adds it to the list
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -10.0), 6.0,new Material(3.0, 3.0, 100), new Color(148,0,211));
		geoList.add(sphere);
		//Sets up an empty list of lights
		ArrayList lights = new ArrayList<LightSource>();
		//Creates a spotlight to add to our scene
		pointLight pointLight = new pointLight(new Point3D(25,25,-2));
		lights.add(pointLight);
		//Creates a scene to hold it all
		Scene scene = new Scene("PointLightTestScene", new Color(0,0,0), ambientLight, lights, geoList, camera, 30.0);
		//Creates an ImageWriter instance to help write down what our camera sees
		ImageWriter imageWriter = new ImageWriter("PointLightTest", 500, 500, 100, 100);
		//Creates a Render instance to pull it all together
		Render render = new Render(scene, imageWriter);


		//Records what the camera sees
		render.RenderImage();
		//Prints it all to a file
		imageWriter.writeToimage();
	}
	
	@Test
	public void ballOnTheFloorTest() {
		AmbientLight ambientLight = new AmbientLight(new Color(255, 255, 255), 1.0);
		Camera camera = new Camera();
		ArrayList geoList = new ArrayList<Geometry>();
		Plane floor = new Plane(new Point3D(-10, -3, -1), new Point3D(10, -3, -1), new Point3D(0, -3, -12), new Material(), new Color(200, 200, 200));
		geoList.add(floor);
//		Triangle floor1 = new Triangle(new Point3D(-1.5, -3, 0), new Point3D(1.5, -3, 0), new Point3D(1.5, -3, 3), new Material(), new Color(200, 200, 200));
//		geoList.add(floor1);
//		Triangle floor2 = new Triangle(new Point3D(-1.5, -3, 0), new Point3D(-1.5, -3, 3), new Point3D(1.5, -3, 3), new Material(), new Color(200, 200, 200));
//		geoList.add(floor2);
		Sphere ball = new Sphere(new Point3D(0, 0, -1.75),1.4985, new Material(), new Color(100, 100, 100));
      		geoList.add(ball);
		ArrayList lightList = new ArrayList<LightSource>();
		pointLight pLight = new pointLight(new Color(255, 0, 0),new Point3D(-4, 4, -1.75), 0.9, 0.9, 0.9);
		lightList.add(pLight);
		pointLight greenlight = new pointLight(new Color(0, 255, 0), new Point3D(4, 4, -1.75), 0.5, 0.5, 0.5);
		lightList.add(greenlight);
		Scene scene = new Scene("Ball on floor test", new Color(30, 30, 30), ambientLight, lightList, geoList, camera, 10.0);
		ImageWriter imageWriter = new ImageWriter("BallOnTheFloorTest", 1000, 1000, 100, 100);
		//Creates a Render instance to pull it all together
		Render render = new Render(scene, imageWriter);

		//Records what the camera sees
		render.RenderImage();
		//Prints it all to a file
		imageWriter.writeToimage();
	}
	
	@Test
	public void floorTest() {
		AmbientLight ambientLight = new AmbientLight(new Color(255, 255, 255), 1.0);
		Camera camera = new Camera();
		ArrayList geoList = new ArrayList<Geometry>();
		Plane floor = new Plane(new Point3D(-10, -3, -1), new Point3D(10, -3, -1), new Point3D(0, -3, -12), new Material(), new Color(200, 200, 200));
		geoList.add(floor);
//		Triangle floor1 = new Triangle(new Point3D(-1.5, -3, 0), new Point3D(1.5, -3, 0), new Point3D(1.5, -3, 3), new Material(), new Color(200, 200, 200));
//		geoList.add(floor1);
//		Triangle floor2 = new Triangle(new Point3D(-1.5, -3, 0), new Point3D(-1.5, -3, 3), new Point3D(1.5, -3, 3), new Material(), new Color(200, 200, 200));
//		geoList.add(floor2);
		ArrayList lightList = new ArrayList<LightSource>();
		pointLight pLight = new pointLight( new Color(255, 0, 0),new Point3D(-25, 25, -20.0), 0.9, 0.9, 0.9);
		//lightList.add(pointlight);
		pointLight greenlight = new pointLight( new Color(0, 255, 0), new Point3D(0, 0, -1), 0.5, 0.5, 0.5);
		lightList.add(greenlight);
		Scene scene = new Scene("Floor test", new Color(30, 30, 30), ambientLight, lightList, geoList, camera, 10.0);
		ImageWriter imageWriter = new ImageWriter("floorTest5", 1000, 1000, 100, 100);
		//Creates a Render instance to pull it all together
		Render render = new Render(scene, imageWriter);

		//Records what the camera sees
		render.RenderImage();
		//Prints it all to a file
		imageWriter.writeToimage();
	}
}