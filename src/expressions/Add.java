package expressions;
import java.util.*;

import model.Expression;
import model.RGBColor;
import model.util.ColorCombinations;

public class Add extends ParenExpression{
	private RGBColor myValue;
    private String myCommand;
    private ArrayList<Expression> myOperands;
    
	
	public Add()
	{
//		myValue = null;
		myCommand = "add";
//		myOperand1 = null;
//        myOperand2 = null;
		myOperands = new ArrayList<Expression>();

	}
    public Add (String command, ArrayList<Expression> operands)
    {
        
        
    }

	@Override
	public String getCommand() {
		return myCommand;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return ColorCombinations.add(myOperands.get(0).evaluate(x,y), myOperands.get(1).evaluate(x,y));
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
