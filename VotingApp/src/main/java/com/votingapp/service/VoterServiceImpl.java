package com.votingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votingapp.enums.Roles;
import com.votingapp.model.Voter;
import com.votingapp.repositories.VoterRepository;
@Service
public class VoterServiceImpl {
	
	@Autowired
	private VoterRepository repository;
	
	
	public String insertInfo(Voter voter) {
		if (voter!=null) {	
	
			repository.save(voter);
			return "User Registration Done Successfully!";
		}else {			
			return "Please Fill All Details!";
		}
	}

}
