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
            if (isOperand(vals[i])) {
                x = stk.pop();
                y = stk.pop();
                stk.push("(" + y + " " + vals[i] + " " + x + ")");
            }
            else {
                stk.push(vals[i]);
            }
        }
        return "" + stk.pop();
    }

    public static double evalPostfix(String e){
        String[] vals = e.split("\\s+");
        Stack<String> stk = new Stack<>(vals.length);
        double result = 0;
        
        for(int i = 0; i < vals.length; i++) {
            if (isOperand(vals[i])) {
                double x = Double.parseDouble(stk.pop());
                double y = Double.parseDouble(stk.pop());
                char operation = vals[i].charAt(0);
                
                switch(operation){
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
                }
                
                stk.push(String.valueOf(result));
            } else {
                stk.push(vals[i]);
            }
        }
        
        return result;
    }
    
    public static boolean isOperand(String val){
        return (val.equals("*") || val.equals("/") || val.equals("+") || val.equals("-") || val.equals("^"));
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
        
    }
}
