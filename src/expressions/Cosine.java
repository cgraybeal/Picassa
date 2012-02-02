package expressions;

import java.util.ArrayList;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class Cosine extends ParenExpression {
	private RGBColor myValue;
    private String myCommand;
    private ArrayList<Expression> myOperands;
    
	
	public Cosine()
	{
		myOperands = new ArrayList<Expression>();
	}
  

	@Override
	public String getCommand() {
		return myCommand;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return ColorCombinations.Cosine(myOperands.get(0).evaluate(x,y));
	}
	public void update(ArrayList<Expression> list)
	{
		myOperands.add(list.get(0));
		
	}
	public int numOperands()
	{
		return 1;
	}

}
