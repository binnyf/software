/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import java.awt.Color;

/**
 *
 * @author Binyamin
 */
public abstract class Light  {
    protected Color color;
    public double Ka;
    
   public Color getIntensity() 
   {
        int r= color.getRed();
        r *= Ka;
        int b = color.getBlue();
        b*=Ka;
        int g = color.getGreen();
        g*=Ka;
        return new Color(r,b,g);
   };

}