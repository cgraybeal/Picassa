package model.util;

import model.RGBColor;


/**
 * Combine two colors by combining their components.
 * 
 * This is a separate class from color since it is just one set of
 * ways to combine colors, many may exist and we do not want to keep
 * modifying the RGBColor class.
 * 
 * @author Robert C. Duvall
 */
public class ColorCombinations
{
    /**
     * Combine two colors by adding their components.
     */
    public static RGBColor add (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() + right.getRed(), 
                            left.getGreen() + right.getGreen(),
                            left.getBlue() + right.getBlue());
    }

    /**
     * Combine two colors by subtracting their components.
     */
    public static RGBColor subtract (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() - right.getRed(), 
                            left.getGreen() - right.getGreen(),
                            left.getBlue() - right.getBlue());
    }

    /**
     * Combine two colors by multiplying their components.
     */
    public static RGBColor multiply (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() * right.getRed(), 
                            left.getGreen() * right.getGreen(),
                            left.getBlue() * right.getBlue());
    }

    /**
     * Combine two colors by dividing their components.
     */
    public static RGBColor divide (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() / right.getRed(), 
                            left.getGreen() / right.getGreen(),
                            left.getBlue() / right.getBlue());
    }
    
    /**
     * Combine two colors by using modulus.
     */
    public static RGBColor modulus (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() % right.getRed(), 
                            left.getGreen() % right.getGreen(),
                            left.getBlue() % right.getBlue());
    } 
    /**
     * Combine two colors by using exponent.
     */
    public static RGBColor exponent (RGBColor left, RGBColor right)
    {
        return new RGBColor(Math.pow(left.getRed(), right.getRed()),
        					Math.pow(left.getGreen(), right.getGreen()),
        					Math.pow(left.getBlue(), right.getBlue()));
                            
    } 
    /**
     * Negate the color.
     */
    public static RGBColor negate (RGBColor left)
    {
        return new RGBColor(-left.getRed(),
        					-left.getGreen(),
        					-left.getBlue());
                            
    } 
    /**
     * Set the color.
     */
    public static RGBColor colorize (RGBColor red,RGBColor green,RGBColor blue)
    {
        return new RGBColor(red.getRed(),
        					green.getGreen(),
        					blue.getBlue());
                            
    } 
    
    public static RGBColor Sine(RGBColor color)
    {
    	return new RGBColor(Math.sin(color.getRed()),Math.sin(color.getGreen()),Math.sin(color.getBlue()));
    }
    public static RGBColor Cosine(RGBColor color)
    {
    	return new RGBColor(Math.cos(color.getRed()),Math.cos(color.getGreen()),Math.cos(color.getBlue()));
    }
    public static RGBColor Tangent(RGBColor color)
    {
    	return new RGBColor(Math.tan(color.getRed()),Math.tan(color.getGreen()),Math.tan(color.getBlue()));
    }
    public static RGBColor Logarithim(RGBColor color)
    {
    	return new RGBColor(Math.log(color.getRed()),Math.log(color.getGreen()),Math.log(color.getBlue()));
    }
    public static RGBColor RGBtoYCrCb(RGBColor color)//0.615R - 0.515G - 0.100B
    {
    	return new RGBColor(0.299*color.getRed()+0.587*color.getGreen()+0.114*color.getBlue(),
    						-0.147*color.getRed()-0.289*color.getGreen()+0.436*color.getBlue(),
    						0.615*color.getRed()-0.515*color.getGreen()-0.1*color.getBlue());
    }
    public static RGBColor YCrCbtoRGB(RGBColor color)
    {
    	return new RGBColor(color.getRed()+1.14*color.getBlue(),
    						color.getRed()-0.395*color.getGreen()-0.581*color.getBlue(),
    						color.getRed()+2.032*color.getGreen());
    }
    public static RGBColor ArcTangent(RGBColor color)
    {
    	return new RGBColor(Math.atan(color.getRed()),Math.atan(color.getGreen()),Math.atan(color.getBlue()));
    }
    public static RGBColor Floor(RGBColor color)
    {
    	return new RGBColor(Math.floor(color.getRed()),Math.floor(color.getGreen()),Math.floor(color.getBlue()));
    }
    public static RGBColor Ceiling(RGBColor color)
    {
    	return new RGBColor(Math.ceil(color.getRed()),Math.ceil(color.getGreen()),Math.ceil(color.getBlue()));
    }
    public static RGBColor Absolute(RGBColor color)
    {
    	return new RGBColor(Math.abs(color.getRed()),Math.abs(color.getGreen()),Math.abs(color.getBlue()));
    }
    public static RGBColor Clamp(RGBColor color)
    {
    	
    	return new RGBColor(Clamp(color.getRed()),Clamp(color.getGreen()),Clamp(color.getBlue()));
    }
    public static double Clamp(double a)
    {
    	if(a>1){return 1;}
    	if(a<-1){return -1;}
    	return a;
    }
    
    		
}
