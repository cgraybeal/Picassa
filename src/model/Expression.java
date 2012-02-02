package model;
import java.util.*;

import model.ParserException.Type;
import model.util.ColorCombinations;

/**
 * An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical 
 * functions and the leaves represent constant values.
 *
 * @author former student solution
 * @author Robert C. Duvall (added comments, some code)
 */
public interface Expression
{
    
   


    /**
     * Create expression representing the given constant value
     */
   


    /**
     * Create expression representing the given operation between the
     * two given sub-expressions.
     */
   
    
        
	public abstract void update(ArrayList<Expression> list);

	public abstract String getCommand();

	public abstract RGBColor evaluate(double x, double y);

	public abstract int numOperands();
	public abstract Expression parse(Parser curParser);

    public abstract boolean isThisExpression(Parser curParser);
    
   


    /**
     * @return value of expression
     */
//    public RGBColor evaluate ()
//    {
//        if (myCommand == null)
//        {
//            return myValue;
//        }
//        else
//        {
//            if (myCommand.equals("plus"))
//                return ColorCombinations.add(myOperand1.evaluate(), myOperand2.evaluate());
//            else if (myCommand.equals("minus"))
//                return ColorCombinations.subtract(myOperand1.evaluate(), myOperand2.evaluate());
//            else if (myCommand.equals("mul"))
//                return ColorCombinations.multiply(myOperand1.evaluate(), myOperand2.evaluate());
//            else if (myCommand.equals("div"))
//                return ColorCombinations.divide(myOperand1.evaluate(), myOperand2.evaluate());
//            else if (myCommand.equals("mod"))
//                return ColorCombinations.modulus(myOperand1.evaluate(), myOperand2.evaluate());
//            else if (myCommand.equals("exp"))
//                return ColorCombinations.exponent(myOperand1.evaluate(), myOperand2.evaluate());
//            else if (myCommand.equals("neg"))
//                return ColorCombinations.negate(myOperand1.evaluate());
//            else if (myCommand.equals("color"))
//                return ColorCombinations.colorize(myOperand1.evaluate(), myOperand2.evaluate(), myOperand3.evaluate());
//            else
//                throw new ParserException("Unknown Command " + myCommand, Type.UNKNOWN_COMMAND);
//        }
//    }
    
//    


    /**
     * @return string representation of expression
     */
   // public abstract String toString ();
//    {
//        StringBuffer result = new StringBuffer();
//        if (myCommand == null)
//        {
//            result.append(myValue); 
//        }
//        else
//        {
//            result.append("(");
//            result.append(" " + myCommand + " ");
//            result.append(myOperand1.toString());  
//            result.append(myOperand2.toString());
//            result.append(")");
//        }
//        return result.toString();
//    }
}
