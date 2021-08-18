package com.rulesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rulesservice.exception.AccessDeniedException;
import com.rulesservice.feign.AuthorizationFeign;
import com.rulesservice.model.Account;
import com.rulesservice.model.AuthenticationResponse;
import com.rulesservice.model.RulesInput;

@Service
public class RulesServiceImpl implements RulesService {

	@Autowired
	AuthorizationFeign authorizationFeign;

	@Override
	public boolean evaluate(RulesInput account) {
		int min = 1000;
		double check = account.getCurrentBalance() - account.getAmount();
		if (check >= min)
			return true;
		else
			return false;
	}

	@Override
	public AuthenticationResponse hasPermission(String token) {
		AuthenticationResponse validity = authorizationFeign.getValidity(token);
		if (!authorizationFeign.getRole(validity.getUserid()).equals("EMPLOYEE"))
			throw new AccessDeniedException("NOT ALLOWED");
		else
			return validity;
	}

	@Override
	public double serviceCharges(Account account) {
		double detected = 300;
		if(account.getCurrentBalance()>1000)
		{
			return 0.0;
		}
		else if (account.getCurrentBalance() < 1000 && (account.getCurrentBalance() - detected) >= 0) {
			return detected;
		} 
		return account.getCurrentBalance();
	}

}
