import java.util.Stack;
import java.util.Arrays;

public class Evaluator{

    // precondition: exp is a String expression that is fully parenthesized (a set
    //               of parentheses for each operator).
    // postcodition: returns a String [] of the tokens of exp.
    //               ex. getTokens("(5-2.2)") -> ["(","5","-","2.2",")"]
    public static String[] getTokens(String exp){
        exp = exp.replaceAll(" ", "");
        String[] tokens = exp.split("(?<=[^\\.a-zA-Z\\d])|(?=[^\\.a-zA-Z\\d])");
        return tokens;
    }

    // precondition: receives an array of the tokens of an infix expression.
    //               tokens must be one of the following:
    //               (),+-*/%,sqrt
    // postcondition: evalutes the expression represented in expTokens
    //             ex. evaluate(["(","5","-","2.2",")"]) returns 2.8
    public static Double evaluate(String[] expTokens){
      //allocating memory for stacks for operands, operators
      Stack<Double> operands = new Stack<Double>();
      Stack<String> operators = new Stack<String>();
      String ops = "+-/*%";
      Double result = 0.0;

      System.out.println(Arrays.toString(expTokens));

      for (String x: expTokens) {
        if (ops.contains(x) || x.equals("sqrt")) {
          operators.push(x);
        }
        else if (!x.equals("(") && !x.equals(")")) {
          operands.push(Double.parseDouble(x));
        }
      }

      System.out.println(operators);
      System.out.println(operands);

      System.out.println("Adding begins here!");

      if ((int)operators.pop().charAt(0) == 43) {
        Double val1 = operands.pop();
        Double val2 = operands.pop();
        System.out.println("\nval1: " + val1 + "\nval2: " + val2 + "\n");
        result = val1 + val2;
      }

      System.out.println("Adding ends here!");

      System.out.println(operators);
      System.out.println(operands);

      return result;
    }

    ///////////////////////////////////////////////////////

    public static void main(String [] args){

        String[] expressions = {"(2+3)","(4 + (3 - 2))", "((5 *(10 + (32 - 8))/ 2.0))",
                                "( sqrt  (16 * 16) )", "(( 25 % 3 ) + 9)"};
        Double[] expectedResults = {5.0,5.0,85.0,16.0,10.0};
        for (int i = 0; i == 0; i++){
            String[] tokens = getTokens(expressions[i]);
            Double  ansObserved = evaluate(tokens);
            Double  ansExpected = expectedResults[i];
            System.out.println(expressions[i] + " = " + evaluate(tokens));
            System.out.println("observed: " + ansObserved + " expected: " + ansExpected);
            System.out.println("correct? " + (ansObserved.equals( ansExpected)));
        }
    }

}
