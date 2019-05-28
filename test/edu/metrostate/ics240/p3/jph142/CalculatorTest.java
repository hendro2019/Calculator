package edu.metrostate.ics240.p3.jph142;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

import edu.metrostate.ics240.p3.calc.StackCalculator;


class CalculatorTest {

	private static final double INFINITY = 42.0 / 0;

	@Test
	void test() {
		StackCalculator calc = new Calculator();
		
		assertEquals(0, calc.size());
		assertEquals(true, calc.isEmpty());
		assertThrows(EmptyStackException.class, ()->{ calc.peek();});
		assertThrows(EmptyStackException.class, ()->{ calc.pop();});
		
		calc.enter("2");
		calc.enter("4");
		calc.enter("/");
		
		assertEquals(.5, calc.peek());
		
		calc.enter(".5");
		calc.enter("+");
		
		assertEquals(1.0, calc.peek());
		
		calc.enter("BadEntry");
		calc.enter("123BadEntry");
		
		assertEquals(1, calc.size());
		assertThrows(EmptyStackException.class, ()->{ calc.enter("-");});
		assertThrows(EmptyStackException.class, ()->{ calc.enter("+");});
		assertThrows(EmptyStackException.class, ()->{ calc.enter("/");});
		assertThrows(EmptyStackException.class, ()->{ calc.enter("*");});
		
		calc.enter("42");
		calc.enter("42");
		calc.enter("42");
		calc.enter("-");
		calc.enter("/");
		calc.enter("*");
		
		assertEquals(INFINITY, calc.peek());
		
		calc.clear();
		
		assertEquals(true, calc.isEmpty());
		assertEquals(0, calc.size());
	}

}
