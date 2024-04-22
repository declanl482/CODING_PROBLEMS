class Solution {
    
    private boolean isValidOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"); 
    }
    
    private int applyOperator(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> operandStack = new Stack<Integer>();
        
        for (String token : tokens) {
            if (isValidOperator(token)) {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                operandStack.push(applyOperator(token, operand1, operand2));
            }
            else {
                operandStack.push(Integer.parseInt(token));
            }
        }
        
        return operandStack.pop();
    }
}