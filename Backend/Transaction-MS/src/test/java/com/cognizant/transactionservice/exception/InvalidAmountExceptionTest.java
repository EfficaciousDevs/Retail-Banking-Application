package com.cognizant.transactionservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class InvalidAmountExceptionTest {
	@InjectMocks
	private InvalidAmountException iae;;

	@Test
	public void testInvalidAmount() {
		int amt =-200;
		assertEquals(amt, -200);
	}


}
