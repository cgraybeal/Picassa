package expressions;

import java.util.ArrayList;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class Modulus extends ParenExpression{
	private RGBColor myValue;
    private String myCommand;
    private ArrayList<Expression> myOperands;

	
	public Modulus()
	{
		myOperands = new ArrayList<Expression>();

	}
    public Modulus (String command, Expression operand1, Expression operand2)
    {
       
        
    }

	@Override
	public String getCommand() {
		return myCommand;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return ColorCombinations.modulus(myOperands.get(0).evaluate(x,y), myOperands.get(1).evaluate(x,y));
	}
	public void update(ArrayList<Expression> list)
	{
		myOperands.add(list.get(0));
		myOperands.add(list.get(1));
	}
	public int numOperands()
	{
		return 2;
	}
	

}
