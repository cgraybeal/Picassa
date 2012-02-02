package expressions;

import java.util.ArrayList;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class RandomColor extends ParenExpression{
	private RGBColor red;
	private RGBColor green;
	private RGBColor blue;
    private String myCommand;
    private ArrayList<Expression> myOperands;

	
	public RandomColor()
	{
		double a = Math.random()*2 -1;
		double b = Math.random()*2 -1;
		double c = Math.random()*2 -1;
		red = new RGBColor(a);
		green  = new RGBColor(b);
		blue = new RGBColor(c);
		myCommand = "random";
		myOperands = new ArrayList<Expression>();

		
	}
    

	@Override
	public String getCommand() {
		return myCommand;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		
		return ColorCombinations.colorize(red,green,blue);
	}
	
	public void update(ArrayList<Expression> list)
	{
		
				
	}
	public int numOperands()
	{
		return 0;
	}

}
