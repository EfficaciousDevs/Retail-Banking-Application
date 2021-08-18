package com.cognizant.transactionservice.controller;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cognizant.transactionservice.exception.GlobalExceptionHandler;
import com.cognizant.transactionservice.exception.MinimumBalanceException;
import com.cognizant.transactionservice.models.AccountInput;
import com.cognizant.transactionservice.models.Transaction;
import com.cognizant.transactionservice.models.TransactionInput;
import com.cognizant.transactionservice.repository.TransactionRepository;
import com.cognizant.transactionservice.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.rulesservice.model.AuthenticationResponse;

@WebMvcTest
@ExtendWith(SpringExtension.class)

public class TransactionRestControllerTest {
	@SuppressWarnings("unused")
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private TransactionRepository transRepo;
	@Mock
	TransactionService transactionService;
	String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJFTVBMT1lFRTEwMSIsImV4cCI6MTYxNjQxODk0OCwiaWF0IjoxNjE2NDE3MTQ4fQ.ln-8ceskNQJuKQWPygb9bbM89fiJ-lJphoem2-_Eulk";
	
	@Autowired
	private WebApplicationContext wc;

	static ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws JsonProcessingException, Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}
	
	


	@Test
	public void getAllTransactionById() throws Exception {
		new Transaction();
		MvcResult andReturn = mockMvc.perform(get("/transactions/getAllTransByAccId/10054546").header("Authorization", token)).andExpect(status().isOk()).andReturn();
		andReturn.getResponse().getContentAsString();

	}
	
//	@Test
//	public void getAllTransaction() throws Exception {
//		TransactionInput trans=new TransactionInput();
//		trans.setSourceAccount(new AccountInput(10054546,10000, 1000.0));
//		trans.setTargetAccount(new AccountInput(10054546,1000, 1000.0));
//		trans.setAmount(1000.0);
//		trans.setReference("TRANSFER");
//		MvcResult andReturn = mockMvc.perform(post("/transactions")
//				.content(asJsonString(trans))
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON)
//				.header("Authorization", token))
//				.andExpect(status().is(406)).andReturn();
//		andReturn.getResponse().getContentAsString();
//	}
	
	@Test
	public void withdraw() throws Exception {
		AccountInput trans=new AccountInput(10054546, 5000, 100.0);
		 MvcResult andReturn = mockMvc.perform(post("/transactions/withdraw")
				.content(asJsonString(trans))
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", token))
				.andExpect(status().is(406)).andReturn();
		 String contentAsString = andReturn.getResponse().getContentAsString();
		 System.err.println(contentAsString);
	}
	
	@Test
	public void servicecharge() throws Exception {
		AccountInput trans=new AccountInput(10054546,10000, 100.0);
		 MvcResult andReturn = mockMvc.perform(post("/transactions/servicecharge")
				.content(asJsonString(trans))
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", token))
				.andExpect(status().isOk()).andReturn();
		 String contentAsString = andReturn.getResponse().getContentAsString();
		 System.err.println(contentAsString);
	}
	
	@Test
	public void deposit() throws Exception {
		AccountInput trans=new AccountInput(10054546,10000, 100.0);
		MvcResult andReturn = mockMvc.perform(post("/transactions/deposit")
				.content(asJsonString(trans))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization", token))
				.andExpect(status().isOk()).andReturn();
		andReturn.getResponse().getContentAsString();
	}
	
	@Test
	public void minimumBal() throws MinimumBalanceException,Exception {
		MinimumBalanceException minimumBalanceException = new MinimumBalanceException();
		MinimumBalanceException minimumBalanceException2 = new MinimumBalanceException("Hi");
		assertNotEquals(minimumBalanceException, minimumBalanceException2);
		new GlobalExceptionHandler();

		
	}
	

	
	
	public static String asJsonString(final Object obj) throws JsonProcessingException {
		
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		
	}

}
