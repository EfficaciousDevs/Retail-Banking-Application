package com.cognizant.authenticationservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import com.cognizant.authenticationservice.exceptionhandling.AppUserNotFoundException;

public class AppUserNotFountTest {
	
	@Test
	public void appTest()
	{
		AppUserNotFoundException ae=new AppUserNotFoundException();
		AppUserNotFoundException ae1=new AppUserNotFoundException();
		assertNotEquals(ae, ae1);
		//assertThat(ae).isNotEqualTo(ae1);
	}
	
	@Test
	public void appTest1()
	{
		AppUserNotFoundException ae=new AppUserNotFoundException("hello");
		AppUserNotFoundException ae1=new AppUserNotFoundException("hello");
		assertNotEquals(ae, ae1);
		//assertThat(ae).isNotEqualTo(ae1);
	}
}
