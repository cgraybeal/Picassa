package expressions;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Expression;
import model.Parser;
import model.ParserException;
import model.RGBColor;

public  class ParenExpression implements Expression{
	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
			.compile("\\(([a-z]+)");
	
	public  boolean isThisExpression(Parser curParser)
	{
		Matcher doubleMatcher = EXPRESSION_BEGIN_REGEX.matcher(curParser.getMyInput()
				.substring(curParser.getCurrentPosition()));
		return doubleMatcher.lookingAt();
	}
	public Expression parse(Parser curParser) {
		Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(curParser.getMyInput());
		expMatcher.find(curParser.getCurrentPosition());
		String commandName = expMatcher.group(1);
		curParser.setCurrentPosition(expMatcher.end());
		curParser.fillMap();
		Expression temp = curParser.getExpressionMap().get(commandName);

		ArrayList<Expression> parameters = new ArrayList<Expression>();

		while (curParser.currentCharacter() != ')') {
			curParser.skipWhiteSpace();
			Expression a = curParser.parseExpression();
			parameters.add(a);
			curParser.skipWhiteSpace();
		}

		if (curParser.currentCharacter() == ')') {
			curParser.setCurrentPosition(curParser.getCurrentPosition()+1);
			temp.update(parameters);
			return temp; 
		} 
		else {
			throw new ParserException("Expected close paren, instead found "
					+ curParser.getMyInput().substring(curParser.getCurrentPosition()));
		}

	}
	

	@Override
	public void update(ArrayList<Expression> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCommand(){return null;}

	@Override
	public RGBColor evaluate(double x, double y){return null;}

	@Override
	public int numOperands(){return 0;}
	

}
