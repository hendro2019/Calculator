package edu.metrostate.ics240.p3.calc;

public interface StackCalculator {
	/**
	 * Processes an entry to the calculator. If a double value, the entry is
	 * pushed onto the stack. If an operator (+, -, /,or *), the operands are
	 * popped from the stack and the result of the operation is pushed onto the
	 * stack. Note: the second operand is popped first.
	 * 
	 * @param entry entry to the calculator, either a double value or a valid operator
	 * 
	 */
	void enter(String entry);

	/**
	 * Looks at the number at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return top number of this stack
	 * @throws EmptyStackException
	 *             - if this stack is empty
	 */
	double peek();

	/**
	 * Removes the number at the top of this stack and returns that value.
	 * 
	 * @return the number at the the top of this stack
	 * @throws EmptyStackException
	 *             - if this stack is empty
	 */
	double pop();

	/**
	 * Removes all numbers from this stack. The stack will be empty after this
	 * call returns
	 */
	void clear();

	/**
	 * Tests if the number stack of this calculator is empty
	 * 
	 * @return true if and only if this calculator's stack has no values, false
	 *         otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns the number of values in this calculators number stack.
	 * 
	 * @return the number of values in this calculators number stack
	 */
	int size();
}
