package expressions;

import java.util.ArrayList;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class Negate extends ParenExpression{
	private RGBColor myValue;
    private String myCommand;
    private ArrayList<Expression> myOperands;
    
	
	public Negate()
	{
		myOperands = new ArrayList<Expression>();
	}
    public Negate (String command, Expression operand1, Expression operand2)
    {
//        myCommand = command;
//        myOperand1 = operand1;
//        myValue = null;
        
    }

	@Override
	public String getCommand() {
		return myCommand;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return ColorCombinations.negate(myOperands.get(0).evaluate(x,y));
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
