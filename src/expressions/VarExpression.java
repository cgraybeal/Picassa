package expressions;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Expression;
import model.Parser;
import model.ParserException;
import model.RGBColor;

public class VarExpression implements Expression{
	private static final Pattern VARIABLE_REGEX = Pattern.compile("x|y");
	private RGBColor myValue;
    private String myCommand;

    public VarExpression()
    {}
    
    public VarExpression (String command)
    {
        myValue = null;
        myCommand = command;
       
    }

	@Override
	public RGBColor evaluate(double x, double y) {
		{
	    	if(myCommand==null)
	    	{
	    		return myValue;
	    	}
	    	else if(myCommand.equals("x"))
	    	{
	    		return new RGBColor(x);
	    	}
	    	else if(myCommand.equals("y"))
	    	{
	    		return new RGBColor(y);
	    	}
	    	else
	            throw new ParserException("Unknown Command " + myCommand);
	    }
	    
	}
	
	public Expression parse(Parser curParser) {
		Matcher varMatcher = VARIABLE_REGEX.matcher(curParser.getMyInput());
		varMatcher.find(curParser.getCurrentPosition());
		String varMatch = curParser.getMyInput().substring(varMatcher.start(),
				varMatcher.end());
		curParser.setCurrentPosition(varMatcher.end());
		

		return new VarExpression(varMatch);
	}
	
	public String getCommand()
	 {
	    	return myCommand;
	 }

	@Override
	public void update(ArrayList<Expression> list) {
		// TODO Auto-generated method stub
		
	}
	public boolean isThisExpression(Parser curParser)
	{
		Matcher doubleMatcher = VARIABLE_REGEX.matcher(curParser.getMyInput()
				.substring(curParser.getCurrentPosition()));
		return doubleMatcher.lookingAt();
	}

	@Override
	public int numOperands() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
