package expressions;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Expression;
import model.Parser;
import model.RGBColor;

public class NumExpression implements Expression{
	private RGBColor myValue;
    private String myCommand;
    private static final Pattern DOUBLE_REGEX = Pattern
			.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
    
    public NumExpression()
    {
    	
    }
    
	public NumExpression(RGBColor value) {
		myValue = value;
		myCommand = null;
		
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return myValue;
	}
	
	public String getCommand()
	 {
	    	return myCommand;
	 }
	public void update(ArrayList<Expression> list)
	{
		
	}
	public boolean isThisExpression(Parser curParser)
	{
		Matcher doubleMatcher = DOUBLE_REGEX.matcher(curParser.getMyInput()
				.substring(curParser.getCurrentPosition()));
		return doubleMatcher.lookingAt();
	}

	public  Expression parse(Parser curParser) {
		Matcher doubleMatcher = DOUBLE_REGEX.matcher(curParser.getMyInput());
		doubleMatcher.find(curParser.getCurrentPosition());
		String numberMatch = curParser.getMyInput().substring(doubleMatcher.start(),
				doubleMatcher.end());
		curParser.setCurrentPosition(doubleMatcher.end());
		// this represents the color gray of the given intensity
		double value = Double.parseDouble(numberMatch);
		RGBColor gray = new RGBColor(value);
		return new NumExpression(gray);
	}
	
	@Override
	public int numOperands() {
		
		return 0;
	}

	
	

}
