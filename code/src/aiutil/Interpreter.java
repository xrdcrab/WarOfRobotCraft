package aiutil;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import controller.Controller;
import model.AIPlayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author seanw
 */
public class Interpreter {

	LinkedList<String> lines = new LinkedList<String>();
	// Only stores the new define operations
	Dictionary<String, String> declarations = new Hashtable<String, String>();
	Stack<String> stack = new Stack<String>();
	Dictionary<String, String> variableDeclarations = new Hashtable<String, String>();
	AIPlayer aiPlayer;

	/**
	 * This method is to define a new operation, and put it into the operation dictionary. 
	 * @param statement
	 * @param i
	 * @return
	 */
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

	/**
	 * This is to define a variable name. 
	 * @param string, the statement
	 * @param integer i
	 * @return integer
	 */
	private int defineVar(String[] statement, int i) {
		i++;
		String key = statement[i];
		this.variableDeclarations.put(key, "");
		i++;
		return i;
	}

    /**
     * This is to assign a value to a variable.
	 * @param string, the statement
	 * @param integer i
	 * @return integer
     */
	private int setVar(String[] statement, int i) {
		String key = this.stack.pop();
		String value = this.stack.pop();
		variableDeclarations.put(key, value);
		i++;
		return i;
	}

	/**
	 * This is to query a variable to take the value of it. 
	 * @param string, the statement
	 * @param integer i
	 * @return integer
	 */
	private int queryVariable(String[] statement, int i) {
		String key = this.stack.pop();
		String value = this.variableDeclarations.get(key);
		this.stack.push(value);
		i++;
		return i;
	}

	/**
	 * This is a helper function to implement "." in Forth. 
	 * @param string, the statement
	 * @param integer i
	 * @return integer
	 */
	private int popStack(String[] statement, int i) {
		System.out.println(this.stack.pop());
		i++;
		return i;
	}

	/**
	 * This is a helper function to implement "random" in Forth 
	 */
	private void random() {
		Random rand = new Random();
		int value = Integer.parseInt(this.stack.pop());
		int num = rand.nextInt(value + 1);
		this.stack.push(String.valueOf(num));
	}

	/**
	 * This is a helper function to parse "if" statement in Forth.
	 * @param string, the statement
	 * @param integer i
	 * @return integer
	 */
	private int ifStatement(String[] statement, int i) {
		String trueStatement = "";
		String falseStatement = "";
		for (i++; i < statement.length && !statement[i].equals("else") && !statement[i].equals("then"); i++) {
			trueStatement += statement[i] + " ";
		}
		
		for (i++; i < statement.length && !statement[i].equals("then"); i++) {
			falseStatement += statement[i] + " ";
		}
		// If the determination is true, execute true statement. 
		if (Boolean.parseBoolean(stack.pop())) {
			runStatement(trueStatement.split(" "));
		} else {
			runStatement(falseStatement.split(" "));
		}

		return i;
	}
	
	/**
	 * This is a helper function to perform "for" loop, but its still in construction. 
	 * @param string, the statement
	 * @param integer i
	 * @return integer
	 */
	private int forLoop(String[] statement, int i) {
		int start;
		int end;

		return i;
	}

	// Basic operations >>>>>>
    /**
     * This is a helper funciton of perform "+" operation of Forth
     */
	private void add() {
		Double a = Double.parseDouble(stack.pop());
		Double b = Double.parseDouble(stack.pop());
		stack.push((a + b) + "");
	}

	private void minus() {
		Double a = Double.parseDouble(stack.pop());
		Double b = Double.parseDouble(stack.pop());
		stack.push((b - a) + "");
	}

	private void multiply() {
		Double a = Double.parseDouble(stack.pop());
		Double b = Double.parseDouble(stack.pop());
		stack.push((a * b) + "");
	}

	private void divide() {
		Double a = Double.parseDouble(stack.pop());
		Double b = Double.parseDouble(stack.pop());
		stack.push((b / a) + "");
	}

	private void mod() {
		Double a = Double.parseDouble(stack.pop());
		Double b = Double.parseDouble(stack.pop());
		stack.push((b % a) + "");
	}

	private void lessThan() {
		Double a = Double.parseDouble(stack.pop());
		Double b = Double.parseDouble(stack.pop());
		stack.push((b < a) + "");
	}

	private void lessThanOrEqual() {
		Double a = Double.parseDouble(stack.pop());
		Double b = Double.parseDouble(stack.pop());
		stack.push((b <= a) + "");
	}

	private void equal() {
		Double a = Double.parseDouble(stack.pop());
		Double b = Double.parseDouble(stack.pop());
		stack.push((b == a) + "");
	}

	private void notEqual() {
		Double a = Double.parseDouble(stack.pop());
		Double b = Double.parseDouble(stack.pop());
		stack.push((b != a) + "");
	}

	private void largerThanOrEqual() {
		Double a = Double.parseDouble(stack.pop());
		Double b = Double.parseDouble(stack.pop());
		stack.push((b >= a) + "");
	}

	private void largerThan() {
		Double a = Double.parseDouble(stack.pop());
		Double b = Double.parseDouble(stack.pop());
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

	// Basic operations <<<<<
	/**
	 * This is a helper function to help the interpreter to omit the comments of the Forth script. 
	 * @param string, the statement
	 * @param integer i
	 * @return integer
	 */
	private int omitComments(String[] statement, int i) {
		if (statement[i].equals("") || statement[i].equals("\t")) {
			i++;
		}
		Stack<String> parenthesesStack = new Stack<String>();
		// Push the first parentheses onto the stack
		parenthesesStack.push(statement[i]);
		for (i++; i < statement.length; i++) {
			if (statement[i].equals("(")) {
				parenthesesStack.push("(");
			} else if (statement[i].equals(")")) {
				parenthesesStack.pop();
			}
			if (parenthesesStack.isEmpty()) {
				break;
			}
		}
		return i;
	}

	//////////////// Robot operations ////////////////
	private void move() {
		this.aiPlayer.move(Controller.mapSizeGlobal);
	}

	private void shoot() {
		this.aiPlayer.shoot(Integer.parseInt(this.stack.pop()), Controller.mapSizeGlobal);
		this.stack.pop();
	}

	private void turn() {
		this.aiPlayer.turn(Integer.parseInt(this.stack.pop()));
	}

	////////////////////////////////////////////////
	/**
	 * This is an important method of the interpreter. It take an array of string, and switch case 
	 * for each element of the array. If the case is a keyword of the Forth, it execute an operation.  
	 * If the string is neither defined word nor keyword, it is pushed into the stack. 
	 * @param statement
	 */
	private void runStatement(String[] statement) {
		for (int i = 0; i < statement.length; i++) {
			if (statement[i].equals("") || statement[i].equals("\t")) {
				continue;
			}
			;
			String s = statement[i];
			switch (s) {
			// () means comments
			case "(":
				i = omitComments(statement, i);
				break;
			case ")":
				break;
			case ":":
				i = define(statement, i);
				break;
			case "variable":
				i = defineVar(statement, i);
				break;
			case "!":
				i = setVar(statement, i);
				break;
			case "?":
				i = queryVariable(statement, i);
				break;
			case ".":
				i = popStack(statement, i);
				break;
			case "random":
				random();
				break;

			case "if":
				i = ifStatement(statement, i);
				break;
			// First: the counted loop
			case "do":
				i = forLoop(statement, i);
				break;
			// Second: the guarded loop (DO WHILE loop)
			// TODO

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
			case "move":
				move();
				break;
			case "turn":
				turn();
				break;
			case "shoot":
				shoot();
				break;

			default:
				// If no declaration in the dictionary, push onto stack without
				// any action.
				if (declarations.get(s) == null) {
					stack.push(s);
				} else {
					runStatement(declarations.get(s).split(" "));
				}
				break;
			}
		}
	}

	public void run() {
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

	/**
	 * This is a public method for running the interpreter by an aiPlayer
	 * 
	 * @param aiPlayer
	 */

	public void run(AIPlayer aiPlayer) {
		this.aiPlayer = aiPlayer;
		LinkedList<String> statements = new LinkedList<String>();
		for (String line : aiPlayer.getCurrentRobot().getCode()) {
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
		// lines.add(": determineAdult 18 < if no");
		// lines.add("else yes");
		// lines.add("then ; ");
		// lines.add("20 determineAdult ; ");
		// lines.add("drop ;");
		// lines.add("12 determineAdult ; ");
		//
		lines.add(" : string  ");
		lines.add(" true if a  ");
		lines.add(" else  b  ");
		lines.add(" then ");
		lines.add(" ; ");
		lines.add(" string ; ");

		// lines.add("1 2 + ;"); // 3
		// lines.add(": double dup + ;"); // 3
		// lines.add("2 ;"); // 3 2
		// lines.add("double ;"); // 3 4
		// lines.add("double ;"); // 3 8
		// lines.add(": triple dup double + ;"); // 3 8
		// lines.add("triple ;"); // 3 24
		// lines.add("12 ( this is a number ) - ;"); // 3 12
		// lines.add("5 ;"); // 3 12 5
		// lines.add(": quadruple double double ; "); // 3 12 5
		// lines.add(" ( This is a comment ) quadruple ( This is a comment )
		// ;"); // 3 12 20
		// lines.add(": *8 double quadruple ;"); // 3 12 20
		// lines.add(" ( : *8 double quadruple ) ;"); // 3 12 20
		// lines.add(": t 2 ;"); // 3 12 20
		// lines.add("t double ;"); // 3 12 20 4
		// lines.add(" : square dup * ;"); // 3 12 20 4
		// lines.add(" square ; "); // 3 12 20 16
		// lines.add(" drop ; "); // 3 12 20
		// lines.add(" swap ; "); // 3 20 12
		// lines.add(" % ; "); // 3 8
		// lines.add(" 5 6 > 7 8 = 9 10 < 1 1 <> 2 2 <= 3 3 >= ; "); // 3 8
		// false false true false true true
		// lines.add("and ;"); // 3 8 false false true false true
		// lines.add("or ;"); // 3 8 false false true true
		// lines.add("invert ;"); // 3 8 false false true false
		// lines.add("if drop else drop drop then 0 ;");
	}

	public static void main(String[] args) {
		Interpreter t = new Interpreter();
		t.setStrings();
		t.run();
	}
}
