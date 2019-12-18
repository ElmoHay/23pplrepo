package com.example._23people.demo23ppl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.example._23people.demo23ppl.validators.ValidationLogic;

import org.junit.jupiter.api.Test;

class DemoApplicationTests {

	@Test
	void testMyRUT(){
		assertTrue(ValidationLogic.validarRut("15908305-5")); 
	}
	@Test
	void testMyRUTwithoutDash(){
		assertTrue(ValidationLogic.validarRut("159083055")); 
	}
	@Test
	void testARUTwithValidCharDV(){
		assertTrue(ValidationLogic.validarRut("7870697-K")); 
	}
	@Test
	void testARUTwithValidCharDVandWithoutDash(){
		assertTrue(ValidationLogic.validarRut("7870697K")); 
	}
	@Test
	void testARUTwithValidLowercaseCharDV(){
		assertTrue(ValidationLogic.validarRut("7870697-k")); 
	}
	@Test
	void testMyRUTwithInvalidDV(){
		assertFalse(ValidationLogic.validarRut("15908305-0")); 
	}
	@Test
	void testInvalidRUT(){
		assertFalse(ValidationLogic.validarRut("asdf")); 
	}
}
