package model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import expressions.*;
import expressions.RandomColor;

/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser is
 * used http://en.wikipedia.org/wiki/Recursive_descent_parser
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public class Parser {
	// double is made up of an optional negative sign, followed by a sequence
	// of one or more digits, optionally followed by a period, then possibly
	// another sequence of digits
	private static final Pattern DOUBLE_REGEX = Pattern
			.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
	// expression begins with a left paren followed by the command name,
	// which is a sequence of alphabetic characters
	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
			.compile("\\(([a-z]+)");
	private static final Pattern VARIABLE_REGEX = Pattern.compile("x|y");
	private TreeMap<String, Expression> expressionMap;

	// fills map
	public void fillMap() {
		setExpressionMap(new TreeMap<String, Expression>());

		getExpressionMap().put("plus", new Add());
		getExpressionMap().put("minus", new Subtract());
		getExpressionMap().put("mul", new Multiply());
		getExpressionMap().put("div", new Divide());
		getExpressionMap().put("mod", new Modulus());
		getExpressionMap().put("exp", new Exponent());
		getExpressionMap().put("neg", new Negate());
		getExpressionMap().put("color", new Color());
		getExpressionMap().put("random", new RandomColor());
		getExpressionMap().put("sin", new Sine());
		getExpressionMap().put("cos", new Cosine());
		getExpressionMap().put("tan", new Tangent());
		getExpressionMap().put("log", new Logarithim());
		getExpressionMap().put("rgbtoycrcb", new RGBtoYCRCB());
		getExpressionMap().put("ycrcbtorgb", new YCRCBtoRGB());
		getExpressionMap().put("atan", new ArcTangent());
		getExpressionMap().put("floor", new Floor());
		getExpressionMap().put("ceil", new Ceiling());
		getExpressionMap().put("abs", new Absolute());
		getExpressionMap().put("clamp", new Clamp());

	}

	// different possible kinds of expressions
	private static enum ExpressionType {
		NUMBER, PAREN_EXPRESSION, VARIABLE
	}

	// state of the parser
	private int myCurrentPosition;
	private String myInput;

	/**
	 * Converts given string into expression tree.
	 * 
	 * @param input
	 *            expression given in the language to be parsed
	 * @return expression tree representing the given formula
	 */
	public Expression makeExpression(String input) {
		setMyInput(input);
		myCurrentPosition = 0;
		Expression result = parseExpression();
		skipWhiteSpace();
		if (notAtEndOfString()) {
			throw new ParserException(
					"Unexpected characters at end of the string: "
							+ getMyInput().substring(myCurrentPosition),
					ParserException.Type.EXTRA_CHARACTERS);
		}
		return result;
	}

//	private ExpressionType getExpressionType() {
//		skipWhiteSpace();
//		if (NumExpression.isThisExpression(this))
//			return ExpressionType.NUMBER;
//		if (ParenExpression.isThisExpression(getMyInput(), myCurrentPosition))
//			return ExpressionType.PAREN_EXPRESSION;
//		if (VarExpression.isThisExpression(getMyInput(), myCurrentPosition))
//		{
//			return ExpressionType.VARIABLE;
//		}
//			
//		else
//			
//			throw new ParserException("Unexpected Character "
//					+ currentCharacter());
//	}

	public Expression parseExpression() {
		List<Expression> expressionTypes = new ArrayList<Expression>();
		expressionTypes.add(new ParenExpression());
		expressionTypes.add(new VarExpression());
		expressionTypes.add(new NumExpression());
		
		for(int i = 0; i< expressionTypes.size(); i++)
		{
			if(expressionTypes.get(i).isThisExpression(this))
			{
				return expressionTypes.get(i).parse(this);
			}
		}

//		switch (getExpressionType()) {
//		case NUMBER:
//			return NumExpression.parseNumber(this);
//		case PAREN_EXPRESSION:
//			return ParenExpression.parseParenExpression(this);
//		case VARIABLE:
//			return VarExpression.parseVariable(this);
//		default:
			throw new ParserException("Unexpected expression type: ");
				//	+ getExpressionType().toString());
		}
	


	public void skipWhiteSpace() {
		while (notAtEndOfString() && Character.isWhitespace(currentCharacter())) {
			myCurrentPosition++;
		}
	}

	public char currentCharacter() {
		return getMyInput().charAt(myCurrentPosition);
	}

	private boolean notAtEndOfString() {
		return myCurrentPosition < getMyInput().length();
	}

	public String getMyInput() {
		return myInput;
	}

	public void setMyInput(String myInput) {
		this.myInput = myInput;
	}

	public int getCurrentPosition() {
		// TODO Auto-generated method stub
		return myCurrentPosition;
	}
	public void setCurrentPosition(int i)
	{
		myCurrentPosition = i;
	}

	public TreeMap<String, Expression> getExpressionMap() {
		return expressionMap;
	}

	public void setExpressionMap(TreeMap<String, Expression> expressionMap) {
		this.expressionMap = expressionMap;
	}
}
