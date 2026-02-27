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
        for (int i = 0; i < vals.length; i++) {
            if (vals[i].equals("*") || vals[i].equals("/") || vals[i].equals("+") || vals[i].equals("-") || vals[i].equals("^")) {
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
            System.out.println("Postfix:" + s);
            System.out.println("Infix: " + postfixToInfix(s));
            System.out.println("Value: ");
        }
        
    }
}
