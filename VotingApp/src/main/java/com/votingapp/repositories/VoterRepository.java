package com.votingapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.votingapp.model.Voter;

public interface VoterRepository extends CrudRepository<Voter, Long> {
	Voter findByEmail(String email);

}
