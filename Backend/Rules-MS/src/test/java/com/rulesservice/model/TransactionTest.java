package com.rulesservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TransactionTest {

	Transaction tc=new Transaction();
	Transaction transaction2 = new Transaction(1, 2, "harini", 32, "prabha", 1000, null, "deposit");
	
	@Test
	 void setTransactionIdTest()
	{
		tc.setId(1);
		assertEquals(1,tc.getId());
	}
	@Test
	 void setTransactionNameTest()
	{
		tc.setSourceAccountId(1001);
		assertEquals(1001, tc.getSourceAccountId());
	}
	@Test
	 void SetTransactionOwnerTest()
	{
		tc.setSourceOwnerName("harini");
		assertEquals("harini", tc.getSourceOwnerName());
	}
	
	@Test
	 void setTransactionTargetAccIdTest()
	{
		tc.setTargetAccountId(200315);
		assertEquals(200315, tc.getTargetAccountId());
	}
	
	@Test
	 void setTransactionTOwnerTest()
	{
		tc.setTargetOwnerName("bhavya");
		assertEquals("bhavya", tc.getTargetOwnerName());
	}
	
	@Test
	 void SetAmount()
	{
		tc.setAmount(5000);
		assertEquals(5000, tc.getAmount());
	}
	@Test
	 void SetDateTest()
	{
		tc.setInitiationDate(null);
		assertEquals(null, tc.getInitiationDate());
		
	}
	
	@Test
	 void setReferenceTest() {
		tc.setReference("Deposit");
		assertEquals("Deposit", tc.getReference());
	}
	@Test
	 void setIdTest1() {
		assertEquals(1, transaction2.getId());
	}

	@Test
	 void setSourceAccountIdTest1() {
		assertEquals(2, transaction2.getSourceAccountId());
	}

	@Test
	 void setTargetOwnerNameTest1() {
		assertEquals("prabha", transaction2.getTargetOwnerName());
	}

	@Test
	 void setTargetAccountIdTest1() {
		assertEquals(32, transaction2.getTargetAccountId());
	}

	@Test
	 void setAmountTest1() {
		assertEquals(1000, transaction2.getAmount());
	}

	@Test
	 void setReferenceTest1() {
		assertEquals("deposit", transaction2.getReference());
	}

	@Test
	 void setInitiationDateTest1() {
		assertEquals(null, transaction2.getInitiationDate());
	}
	@Test
	 void setSourceOwnerTest1()
	{
		
		assertEquals("harini", transaction2.getSourceOwnerName());
	}
}
