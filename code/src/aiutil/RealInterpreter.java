package aiutil;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author seanw
 */
public class RealInterpreter {

    LinkedList<String> lines = new LinkedList<String>();
//    Only stores the new define operations 
    Dictionary<String, String> declarations = new Hashtable<String, String>();
    Stack<String> stack = new Stack<String>();

    private int define(String[] statement, int i) {
        i++;
        String key = statement[i];
        String newStatement = "";
        for (i++; i < statement.length; i++) {
            newStatement += statement[i] + " ";
        }
        declarations.put(key, newStatement);

        return i;
    }

    private int ifStatement(String[] statement, int i) {
        String trueStatement = "";
        String falseStatement = "";
        for (i++; i < statement.length && !statement[i].equals("else") && !statement[i].equals("then"); i++) {
            trueStatement += statement[i] + " ";
        }
        for (i++; i < statement.length && !statement[i].equals("then"); i++) {
            falseStatement += statement[i] + " ";
        }
        if (Boolean.parseBoolean(stack.pop())) {
            runStatement(trueStatement.split(" "));
        } else {
            runStatement(falseStatement.split(" "));
        }

        return i;
    }

//    Basic operations >>>>>>
    private void add() {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());
        stack.push((a + b) + "");
    }

    private void minus() {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());
        stack.push((b - a) + "");
    }

    private void multiply() {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());
        stack.push((a * b) + "");
    }

    private void divide() {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());
        stack.push((b / a) + "");
    }

    private void mod() {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());
        stack.push((b % a) + "");
    }

    private void lessThan() {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());
        stack.push((b < a) + "");
    }

    private void lessThanOrEqual() {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());
        stack.push((b <= a) + "");
    }

    private void equal() {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());
        stack.push((b == a) + "");
    }

    private void notEqual() {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());
        stack.push((b != a) + "");
    }

    private void largerThanOrEqual() {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());
        stack.push((b >= a) + "");
    }

    private void largerThan() {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());
        stack.push((b > a) + "");
    }

    private void and() {
        Boolean a = Boolean.parseBoolean(stack.pop());
        Boolean b = Boolean.parseBoolean(stack.pop());
        stack.push((b && a) + "");
    }

    private void or() {
        Boolean a = Boolean.parseBoolean(stack.pop());
        Boolean b = Boolean.parseBoolean(stack.pop());
        stack.push((b || a) + "");
    }

    private void invert() {
        Boolean a = Boolean.parseBoolean(stack.pop());
        stack.push(!a + "");
    }

    private void duplicate() {
        stack.push(stack.peek());
    }

    private void drop() {
        stack.pop();
    }

    private void swap() {
        String a = stack.pop();
        String b = stack.pop();
        stack.push(a);
        stack.push(b);
    }

//  Basic operations <<<<< 
    private int omitComments(String[] statement, int i) {
        if (statement[i].equals("") || statement[i].equals("\t")) {
            i++;
        }
        Stack<String> parenthesesStack = new Stack<String>();
//    	Push the first parentheses onto the stack 
        parenthesesStack.push(statement[i]);
        for (i++; i < statement.length; i++) {
            if (statement[i].equals("(")) {
                parenthesesStack.push("(");
            } else if (statement[i].equals(")")) {
                parenthesesStack.pop();
            }
            if (parenthesesStack.isEmpty()) {
                //i++;
                break;
            }
        }
        return i;
    }

    private void runStatement(String[] statement) {
        for (int i = 0; i < statement.length; i++) {
            if (statement[i].equals("") || statement[i].equals("\t")) {
                continue;
            };
            String s = statement[i];
            switch (s) {
//            () means comments 
                case "(":
                    i = omitComments(statement, i);
                    break;
                case ")":
                    break;
                case ":":
                    i = define(statement, i);
                    break;
                case "if":
                    i = ifStatement(statement, i);
                    break;
                case ";":
                    return;
                case "+":
                    add();
                    break;
                case "-":
                    minus();
                    break;
                case "*":
                    multiply();
                    break;
                case "/":
                    divide();
                    break;
                case "%":
                    mod();
                    break;
                case "<":
                    lessThan();
                    break;
                case "<=":
                    lessThanOrEqual();
                    break;
                case "=":
                    equal();
                    break;
                case "<>":
                    notEqual();
                    break;
                case ">=":
                    largerThanOrEqual();
                    break;
                case ">":
                    largerThan();
                    break;
                case "and":
                    and();
                    break;
                case "or":
                    or();
                    break;
                case "invert":
                    invert();
                    break;
                case "dup":
                    duplicate();
                    break;
                case "drop":
                    drop();
                    break;
                case "swap":
                    swap();
                    break;
                default:
//                	If no declaration in the dictionary, push onto stack without any action.
                    if (declarations.get(s) == null) {
                        stack.push(s);
                    } else {
                        runStatement(declarations.get(s).split(" "));
                    }
                    break;
            }
        }
    }

    private void run() {
        LinkedList<String> statements = new LinkedList<String>();
        for (String line : lines) {
            statements.addAll(Arrays.asList(line.split(" ")));
            Boolean canRun = false;
            for (int i = statements.size() - 1; i > 0; i--) {
                switch (statements.get(i)) {
                    case "":
                    case "\t":
                    case "\n":
                        continue;
                    case ";":
                        canRun = true;
                    default:
                        break;
                }
                break;
            }
            if (canRun) {
                runStatement(statements.toArray(new String[statements.size()]));
                statements = new LinkedList<String>();
                for (String str : stack) {
                System.out.print(str + " ");
            }
            }
            System.out.println("");
        }
    }

    private void setStrings() {
        lines.add(": determineAdult 18 < if no");
        lines.add("else yes");
        lines.add("then ; ");
        lines.add("20 determineAdult ; ");
        lines.add("drop ;");
        lines.add("12 determineAdult ; ");

//        lines.add("1 2 + ;"); // 3
//        lines.add(": double dup + ;"); // 3
//        lines.add("2 ;"); // 3 2
//        lines.add("double ;"); // 3 4
//        lines.add("double ;"); // 3 8
//        lines.add(": triple dup double + ;"); // 3 8
//        lines.add("triple ;"); // 3 24
//        lines.add("12 ( this is a number ) - ;"); // 3 12
//        lines.add("5 ;"); // 3 12 5
//        lines.add(": quadruple double double ; "); // 3 12 5
//        lines.add(" ( This is a comment ) quadruple ( This is a comment ) ;"); // 3 12 20
//        lines.add(": *8 double quadruple ;"); // 3 12 20
//        lines.add(" ( : *8 double quadruple ) ;"); // 3 12 20
//        lines.add(": t 2 ;"); // 3 12 20
//        lines.add("t double ;"); // 3 12 20 4
//        lines.add(" : square dup * ;"); // 3 12 20 4
//        lines.add(" square ; "); // 3 12 20 16
//        lines.add(" drop ; "); // 3 12 20
//        lines.add(" swap ; "); // 3 20 12
//        lines.add(" % ; "); // 3 8
//        lines.add(" 5 6 > 7 8 = 9 10 < 1 1 <> 2 2 <= 3 3 >= ; "); // 3 8 false false true false true true
//        lines.add("and ;"); // 3 8 false false true false true 
//        lines.add("or ;"); // 3 8 false false true true 
//        lines.add("invert ;"); // 3 8 false false true false
//        lines.add("if drop else drop drop then 0 ;");
    }

    public static void main(String[] args) {
        RealInterpreter t = new RealInterpreter();
        t.setStrings();
        t.run();
    }
}
