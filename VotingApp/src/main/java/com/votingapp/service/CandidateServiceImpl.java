package com.votingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votingapp.model.Candidate;
import com.votingapp.repositories.CandidateRepository;

@Service
public class CandidateServiceImpl {
	@Autowired
	CandidateRepository repository;
	
	
	public void addCandidates(Candidate candidate) {
		repository.save(candidate);
	}
	
	public List<Candidate> getAllCandidates(){
		return(List<Candidate>) repository.findAll();
	}

}
