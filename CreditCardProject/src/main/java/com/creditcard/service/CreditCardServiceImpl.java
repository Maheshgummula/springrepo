package com.creditcard.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.model.CreditCard;
import com.creditcard.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl {
	Logger logger=LoggerFactory.getLogger(CreditCardServiceImpl.class);
	@Autowired
	CreditCardRepository repository;

public CreditCard	findCreditCardWithPinCode(CreditCard card){
	logger.info("Entered In Service Class");
		return repository.findByMasterPincodesName(card.getMasterPincodesName());
	}

public List<CreditCard>	findByCityAndState(CreditCard card){
	logger.info("Entered In Service Class");
	return repository.findByCityAndState(card.getCity(), card.getState());
}

public List<CreditCard> findAllData(){
	return (List<CreditCard>) repository.findAll();
}
public List<String> getAllStatesUnique(){
	return  repository.findAllStates();
}
public List<String> getAllUniqueCities(String state){
	return  repository.findAllCities(state);
}
}
