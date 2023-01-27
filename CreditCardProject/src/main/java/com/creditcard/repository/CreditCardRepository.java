package com.creditcard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.model.CreditCard;
@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {
@Query(value = "select * from credit_cards_db where MASTER_PINCODES_NAME=?1",nativeQuery = true)
public CreditCard findByMasterPincodesName(Integer masterPincodesName);
 
 @Query(value = "select * from credit_cards_db where CITY=?1 and STATE=?2",nativeQuery = true)
 public List<CreditCard> findByCityAndState(String city,String state);
 
 
 @Query(value = "select distinct state from credit_cards_db",nativeQuery = true)
 public List<String> findAllStates();
 
 
 @Query(value = "select distinct CITY from credit_cards_db where STATE=?1",nativeQuery = true)
 public List<String> findAllCities(String state);
 
 
 
 
 List<CreditCard> findByState(String state);
 
 @Query(value = "select MASTER_PINCODES_NAME from credit_cards_db where CITY=?1 ",nativeQuery = true)
 List<Integer> findByCity(String city);
}
