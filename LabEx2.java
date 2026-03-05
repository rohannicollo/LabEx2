// Teope, Rohan Nicollo M., Tucay, Jack Andie C.
// ICS 2605 1CSD
// Lab Exercise 2

import java.util.Scanner;

public class LabEx2 {
    public static String postfixToInfix(String e) {
        String[] vals = e.split("\\s+");
        String x;
        String y;
        Stack<String> stk = new Stack<>(vals.length);
        for(int i = 0; i < vals.length; i++) {
            if (isOperator(vals[i])) {
                x = stk.pop();
                y = stk.pop();
                stk.push("(" + y + " " + vals[i] + " " + x + ")");
            }
            else {
                stk.push(vals[i]);
            }
        }
        return stk.pop();
    }

    public static double evalPostfix(String e) {
        String[] vals = e.split("\\s+");
        Stack<String> stk = new Stack<>(vals.length);
        double result = 0;
        
        for(int i = 0; i < vals.length; i++) {
            if (isOperator(vals[i])) {
                double x = Double.parseDouble(stk.pop());
                double y = Double.parseDouble(stk.pop());
                char operation = vals[i].charAt(0);
                
                switch(operation) {
                        case '+':
                            result = y + x;
                            break;
                        case '-':
                            result = y - x;
                            break;
                        case '*':
                            result = y * x;
                            break;
                        case '/':
                            result = y / x;
                            break;
                        case '^':
                            result = Math.pow(y, x);
                            break;
                        case '%':
                            result = y % x;
                            break;
                }
                stk.push(String.valueOf(result));
            } else {
                stk.push(vals[i]);
            }
        }
        if (!stk.isEmpty()) {
            return Double.parseDouble(stk.pop());
        }
        return result;
    }
    
    public static String infixToPostfix(String e) {
        String[] vals = e.split("\\s+");
        Stack<String> stk = new Stack<>(vals.length);
        String result = "";
        for (int i = 0; i < vals.length; i++) {
            if (isOperator(vals[i])) {
                while (!vals[i].equals("(") && 
                       !stk.isEmpty() && 
                       !stk.peek().equals("(") && 
                       !(stk.peek().equals("^") && vals[i].equals("^")) &&
                       getPrecedence(stk.peek()) >= getPrecedence(vals[i])) {
                    result += stk.pop() + " ";
                }
                if (vals[i].equals(")")) {
                    stk.pop();
                }
                else {
                    stk.push(vals[i]);
                }
            }
            else {
                result += vals[i] + " ";
            }
        }
        while(!stk.isEmpty()) {
            result += stk.pop() + " ";
        }
        return result.trim();
    }
    
    public static boolean isOperator(String val) {
        return val.equals("*") || val.equals("/") || 
               val.equals("+") || val.equals("-") || 
               val.equals("^") || val.equals("%") || 
               val.equals("(") || val.equals(")");
    }
    
    public static int getPrecedence(String val) {
        switch (val.charAt(0)) {
            case ')' -> {
                return 0;
            }
            case '+', '-' -> {
                return 1;
            }
            case '%' -> {
                return 2;
            }
            case '/', '*' -> {
                return 3;
            }
            case '^' -> {
                return 4;
            }
        }  
        return -1;
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                           Teope, Rohan Nicollo M.
                           Tucay, Jack Andie C.
                           """);
        System.out.print("Enter t: ");
        int t = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter s: ");
        String s = sc.nextLine();
        if (t == 1) {
            System.out.println("\nPostfix: " + s);
            System.out.println("Infix: " + postfixToInfix(s));
            System.out.println("Value: " + evalPostfix(s));
        }
        else if (t == 2) {
            System.out.println("\nInfix: " + s);
            System.out.println("Postfix: " + infixToPostfix(s));
            System.out.println("Value: " + evalPostfix(infixToPostfix(s)));
        }
    }
}
