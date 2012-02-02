package expressions;
import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class Color extends ParenExpression{
	private RGBColor myValue;
    private String myCommand;
    private ArrayList<Expression> myOperands;

	
	public Color()
	{
		myValue = null;
		myCommand = "color";
		myOperands = new ArrayList<Expression>();

		
	}
   

	@Override
	public String getCommand() {
		return myCommand;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return ColorCombinations.colorize(myOperands.get(0).evaluate(x,y), myOperands.get(1).evaluate(x,y),myOperands.get(2).evaluate(x, y));
	}
	
	public void update(ArrayList<Expression> list)
	{
		myOperands.add(list.get(0));
		myOperands.add(list.get(1));
		myOperands.add(list.get(2));
		
	}
	public int numOperands()
	{
		return 3;
	}

}
