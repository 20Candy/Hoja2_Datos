import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void test() {
		calculadora1 calc= new calculadora1();
		stack stack = new stack();
		
		stack.push("+");
		stack.push(2);
		stack.push(1);
		
		int resultado= calc.operar(stack);
		
		assertEquals(resultado,3);
		
	}
	
	@Test
	void test1() {
		calculadora1 calc= new calculadora1();
		stack stack = new stack();
		
		stack.push("*");
		stack.push(2);
		stack.push(1);
		
		int resultado= calc.operar(stack);
		
		assertEquals(resultado,2);
		
		
	}
	
	@Test
	void test2() {
		calculadora1 calc= new calculadora1();
		stack stack = new stack();
		
		stack.push("/");
		stack.push(2);
		stack.push(1);
		
		int resultado= calc.operar(stack);
		
		assertEquals(resultado,2);
		
		
	}
	
	@Test
	void test3() {
		calculadora1 calc= new calculadora1();
		stack stack = new stack();
		
		stack.push("-");
		stack.push(2);
		stack.push(1);
		
		int resultado= calc.operar(stack);
		
		assertEquals(resultado,1);
		
		
	}
	
	@Test
	void test4() {
		calculadora1 calc= new calculadora1();
		stack stack = new stack();
		
		stack.push("/");
		stack.push(9);
		stack.push("*");
		stack.push(3);
		stack.push("+");
		stack.push(2);
		stack.push(1);
		
		int resultado= calc.operar(stack);
		
		assertEquals(resultado,1);
		
		
	}



}
