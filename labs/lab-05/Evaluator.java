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

    //PART 2 - write evaluate(String[] expTokens)
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
        if (x.equals(")")) {
          calculate(operands, operators);
        }
        else if (ops.contains(x) || x.equals("sqrt")) {
          operators.push(x);
        }
        else if (!x.equals("(")) {
          operands.push(Double.parseDouble(x));
        }
      }
      return operands.peek();
    }

    public static void calculate(Stack<Double> operands, Stack<String> operators) {
      Double val1;
      Double val2;
      switch (operators.pop()) {
        case "+":
          val1 = operands.pop();
          val2 = operands.pop();
          operands.push(val1 + val2);
          break;
        case "-":
          val1 = operands.pop();
          val2 = operands.pop();
          operands.push(val2 - val1);
          break;
        case "*":
          val1 = operands.pop();
          val2 = operands.pop();
          operands.push(val1 * val2);
          break;
        case "/":
          val1 = operands.pop();
          val2 = operands.pop();
          operands.push(val2 / val1);
          break;
        case "%":
          val1 = operands.pop();
          val2 = operands.pop();
          operands.push(val2 % val1);
          break;
        case "sqrt":
          val1 = operands.pop();
          operands.push(Math.sqrt(val1));
          break;
        default:
          throw new RuntimeException ("something has gone fatally wrong");
      }
    }

    ///////////////////////////////////////////////////////

    public static void main(String [] args){

        String[] expressions = {"(2+3)","(4 + (3 - 2))", "((5 *(10 + (32 - 8))/ 2.0))",
                                "( sqrt  (16 * 16) )", "(( 25 % 3 ) + 9)"};
        Double[] expectedResults = {5.0,5.0,85.0,16.0,10.0};
        for (int i = 0; i < expressions.length; i++){
            String[] tokens = getTokens(expressions[i]);
            Double  ansObserved = evaluate(tokens);
            Double  ansExpected = expectedResults[i];
            System.out.println(expressions[i] + " = " + ansObserved);
            System.out.println("observed: " + ansObserved + " expected: " + ansExpected);
            System.out.println("correct? " + (ansObserved.equals( ansExpected)));
        }
    }

}
