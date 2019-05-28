package edu.metrostate.ics240.p3.jph142;


import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

import edu.metrostate.ics240.p3.calc.StackCalculator;

public class Calculator implements StackCalculator {
	
	private Stack<Double> stack;
	
	/**
	 * Initializes this stack to an empty LinkedList
	 */
	public Calculator() {
		stack = new Stack<Double>();
	}

	/**
	 * Processes an entry to the calculator. If a double value, the entry is
	 * pushed onto the stack. If an operator (+, -, /,or *), the operands are
	 * popped from the stack and the result of the operation is pushed onto the
	 * stack. Note: the second operand is popped first.
	 * 
	 * @param entry entry to the calculator, either a double value or a valid operator
	 * 
	 */
	@Override
	public void enter(String entry) {
		
		String[] opperators = { "+", "-", "*", "/" };
		
		Arrays.sort(opperators);
		int indx = Arrays.binarySearch(opperators, entry);
		
		if (indx < 0) {
			try {
				stack.push(new Double(entry));
			} 
			
			catch (Exception e) {
				System.out.println("Invalid entry: " + entry);
			}
		}
		
		else if (size() >= 2) {
			double operand2 = pop();
			double operand1 = pop();

			switch (entry) {
			case "+":
				stack.push(operand1 + operand2);
				break;
			case "-":
				stack.push(operand1 - operand2);
				break;
			case "*":
				stack.push(operand1 * operand2);
				break;
			case "/":
				stack.push(operand1 / operand2); // Note: division by 0 is possible.
				break;
			}	
		}
		
		else {
			throw new EmptyStackException();
		}
	}
	
	/**
	 * Looks at the number at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return top number of this stack
	 * 
	 */
	@Override
	public double peek() {
		
		emptyStackCheck();
		return stack.peek();
	}

	/**
	 * Removes the number at the top of this stack and returns that value.
	 * 
	 * @return the number at the the top of this stack
	 * 
	 */
	@Override
	public double pop() {
		
		emptyStackCheck();
		return stack.pop();
	}
	
	/**
	 * Removes all numbers from this stack. The stack will be empty after this
	 * call returns
	 */
	@Override
	public void clear() {
		stack = new Stack<Double>();
		
	}

	/**
	 * Tests if the number stack of this calculator is empty
	 * 
	 * @return true if and only if this calculator's stack has no values, false
	 *         otherwise
	 */
	@Override
	public boolean isEmpty() {
		
		return stack.size() == 0;
	}
	
	/**
	 * Returns the number of values in this calculators number stack.
	 * 
	 * @return the number of values in this calculators number stack
	 */
	@Override
	public int size() {
		
		return stack.size();
	}
	
	/**
	 * Checks to see if this Stack is empty, and if so throws EmptyStackException 
	 */
	private void emptyStackCheck() {
		if (isEmpty())
			throw new EmptyStackException();
	}
}
