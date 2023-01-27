package com.creditcard.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.exceptionhandler.PinCodeNotFoundException;
import com.creditcard.model.CreditCard;
import com.creditcard.repository.CreditCardRepository;
import com.creditcard.service.CreditCardServiceImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
public class CreditCardController {
	Logger logger = LoggerFactory.getLogger(CreditCardController.class);
	@Autowired
	CreditCardRepository repository;

	@Autowired
	CreditCardServiceImpl cardServiceImpl;

	@GetMapping("/findByPincode")
	public ResponseEntity<?> findByPincode(@RequestBody CreditCard card) {
		if (card.getMasterPincodesName() != null) {
			logger.info("Pincode is not null, If Condition is excuted");
			CreditCard creditCard = cardServiceImpl.findCreditCardWithPinCode(card);
//			ResponseEntity<?> check=creditCard!=null? new ResponseEntity<CreditCard>( creditCard, HttpStatus.FOUND): ;
			if (creditCard != null) {
				logger.info("Pincode is found in database, If Condition is excuted");
				return new ResponseEntity<CreditCard>(creditCard, HttpStatus.FOUND);
			} else {
				logger.info("Pincode is Not found in database, Else Condition is excuted");
				throw new PinCodeNotFoundException("Please check your pincode");
			}
//			return (ResponseEntity<?>) check;
		} else {
			logger.info("Pincode is null Else Block is excuted");
			throw new PinCodeNotFoundException("Please Enter Valid Pincode Number");
		}
	}

	
	
	@GetMapping("/findByCityAndstate")
	public ResponseEntity<?> findByCityAndState(@RequestBody CreditCard card) {
		if (card.getCity() != null && card.getState() != null) {
			logger.info("City and State name is not null, If Condition is excuted");
			List<CreditCard> cards = cardServiceImpl.findByCityAndState(card);
			if (!cards.isEmpty()) {
				logger.info("City and State name is found in database, If Condition is excuted");
				JsonArray mainArray=new JsonArray();
				JsonObject state=new JsonObject();
			
					state.addProperty("State", card.getState());
					state.addProperty("City", card.getCity());
					JsonArray pincodesArray=new JsonArray();
					List<Integer> pincodesOfCity = repository.findByCity(card.getCity());
					for (Integer pincodes : pincodesOfCity) {
						pincodesArray.add(pincodes);
					}
					state.add("Pincodes",pincodesArray );
					mainArray.add(state);
				

				
				return new ResponseEntity<Object>(mainArray.toString(), HttpStatus.FOUND);
//				return new ResponseEntity<List<CreditCard>>(cards, HttpStatus.FOUND);
			} else {
				logger.info("City and State name is Not found in database, Else Condition is excuted");
				throw new RuntimeException("Please check you have entered details");
			}
		} else {
			logger.info("City and State name is null Else Block is excuted");
			throw new RuntimeException("Please Enter Valid Names of City and State");
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<Object> getAllData() {
//		//loading All States from database
		List<String> states = cardServiceImpl.getAllStatesUnique();

		// Creating Main/Outer Array
		JsonArray mainarray = new JsonArray();

		// Iterating the the List of States and Outer loop
		for (int i = 0; i < states.size(); i++) {
			JsonObject statedata = new JsonObject();
			JsonArray data = new JsonArray();

			// State Object
			statedata.addProperty("State", states.get(i));

			// Finding all Cities with State name
			List<CreditCard> databystate = repository.findByState(states.get(i));

			// Iterating the inner loop with no of cities present in the State
			for (int j = 0; j < databystate.size(); j++) {
				JsonObject city = new JsonObject();
				city.addProperty("City", databystate.get(j).getCity());
				city.addProperty("Pincode", databystate.get(j).getMasterPincodesName());
				// Adding city into JsonArray
				data.add(city);
				// Adding JsonArray of cities in State object
				statedata.add("Data", data);
			}
			// Adding the state in the Main Array
			mainarray.add(statedata);
		}

		return new ResponseEntity<Object>(mainarray.toString(), HttpStatus.OK);
	}

	@GetMapping("/getAllPincodeByCity")
	public ResponseEntity<?> getAllPincodeByCity() {

		List<String> uniqueStates = cardServiceImpl.getAllStatesUnique();

		JsonArray mainArray = new JsonArray();

		for (String iteratingState : uniqueStates) {

			JsonObject stateobj = new JsonObject();
			stateobj.addProperty("State", iteratingState);
			List<String> uniqueCities = cardServiceImpl.getAllUniqueCities(iteratingState);
			JsonArray allCitiesArray = new JsonArray();

			for (String iteratingCities : uniqueCities) {
				JsonObject cityobj = new JsonObject();
				cityobj.addProperty("City", iteratingCities);

				List<Integer> pincodesOfCity = repository.findByCity(iteratingCities);
				JsonArray pincodes = new JsonArray();
				for (Integer iteratingPincodes : pincodesOfCity) {
					pincodes.add(iteratingPincodes);

				}
				cityobj.add("Pincodes", pincodes);

				allCitiesArray.add(cityobj);

			}
			stateobj.add("Data", allCitiesArray);
			mainArray.add(stateobj);

		}

		return new ResponseEntity<Object>(mainArray.toString(), HttpStatus.FOUND);
	}
	
	
	@GetMapping(value = "/getByCityAndstate")
	public ResponseEntity<?> getData(){
		
		
//		List<CreditCard> cards = cardServiceImpl.findByCityAndState(card);
//		JsonArray mainArray=new JsonArray();
//		JsonObject state=new JsonObject();
//	
//			state.addProperty("State", card.getState());
//			state.addProperty("City", card.getCity());
//			JsonArray pincodesArray=new JsonArray();
//			List<Integer> pincodesOfCity = repository.findByCity(card.getCity());
//			for (Integer pincodes : pincodesOfCity) {
//				pincodesArray.add(pincodes);
//			}
//			state.add("Pincodes",pincodesArray );
//			mainArray.add(state);
//		

		
		return new ResponseEntity<Object>(cardServiceImpl.findAllData(), HttpStatus.FOUND);
	}

}