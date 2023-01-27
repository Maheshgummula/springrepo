package com.votingapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.votingapp.model.Candidate;
@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
@Query(value = "select * from candidate where candidate_name=?1",nativeQuery = true)	
Candidate findByCandidateName(String candidateName);
}
