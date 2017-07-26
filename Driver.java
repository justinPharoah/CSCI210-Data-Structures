import java.io.*;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException {
        InfixToPostfix itp = new InfixToPostfix();
//        EvalPostfix ep = new EvalPostfix();
//        Scanner fileScan = new Scanner(new File("infix.txt"));
//        PrintWriter fileWrite = new PrintWriter(new FileWriter("csis.txt"));
//
//        int expNum = 1;
//        while(fileScan.hasNext()) {
//            String buf = fileScan.nextLine();
//
//            String toEval = itp.infixToPostfix(buf);
//            System.out.println("Postfix notation for expression " + expNum + " is: " + toEval);
//            fileWrite.println("Postfix notation for expression " + expNum + " is: " + toEval);
//
//            int evaluated = ep.evaluate(toEval);
//            System.out.println("Its corresponding evaluation is: " + evaluated + "\n");
//            fileWrite.println("Its corresponding evaluation is: " + evaluated + "\n");
//
//            expNum++;
//        }
//
//        fileScan.close();

        System.out.println(itp.infixToPostfix("8+4*2-6"));
        System.out.println(itp.infixToPostfix("7*2-4*3+2*5"));
        System.out.println(itp.infixToPostfix("2*3*4-8+9/3/3"));
        System.out.println(itp.infixToPostfix("5+7*4-6"));
        System.out.println(itp.infixToPostfix("4*(3+2*4)-7"));
        System.out.println(itp.infixToPostfix("(5+7)/(9-5)"));
        System.out.println(itp.infixToPostfix("3*(5*(5-2))-9"));
        System.out.println(itp.infixToPostfix("((5*(4+2)-(8+8)/2)-9)^3"));
        System.out.println(itp.infixToPostfix("((5+5*(6-2)+4^2)*8)"));
        System.out.println(itp.infixToPostfix("(((3^4)))"));
        System.out.println(itp.infixToPostfix("b+((i-x)*(u-y+1)+(i-y))*e"));
    }
}
