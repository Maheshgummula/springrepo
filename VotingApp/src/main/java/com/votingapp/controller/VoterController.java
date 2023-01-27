package com.votingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.votingapp.enums.Roles;
import com.votingapp.model.Candidate;
import com.votingapp.model.LoginEntity;
import com.votingapp.model.Voter;
import com.votingapp.repositories.CandidateRepository;
import com.votingapp.repositories.LoginRepository;
import com.votingapp.repositories.VoterRepository;
import com.votingapp.service.CandidateServiceImpl;
import com.votingapp.service.LoginServiceImpl;
import com.votingapp.service.VoterServiceImpl;

@Controller
public class VoterController {
	@Autowired
	LoginEntity entity;
	@Autowired
	private VoterServiceImpl impl;
	@Autowired
	private VoterRepository repository;
	
	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	@Autowired
	CandidateServiceImpl cimpl;
	@Autowired
	CandidateRepository candidateRepository;
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "VoterPages/Login";
	}
	
	@GetMapping("/register")
	public String getRegistrationPage() {
		return "VoterPages/Registration";
	}
	@GetMapping("/admin")
	public String getAdminHomePage() {
		return "VoterPages/AdminHomePage";
	}
	
	
	@GetMapping("voter/getVotingPage")
	public String getVotingPage(Model model) {
		List<Candidate> candidates=cimpl.getAllCandidates();
		model.addAttribute("CandidatesList", candidates);
		
		return "VoterPages/VotingPage";
	}
	@GetMapping("/getSuccess")
	public String getSuccess() {
		return "VoterPages/Success";
	}
	@PostMapping("voter/vote")
	public String voting(Candidate candidate,Model model) {
	String username=loginServiceImpl.getUsername();
	Voter v=repository.findByEmail(username);
	Candidate dbcandidate=candidateRepository.findByCandidateName(candidate.getCandidateName());
	System.out.println(dbcandidate);
	if (v.getCandidate()==null) {
		v.setCandidate(dbcandidate);
		impl.insertInfo(v);
		model.addAttribute("Message", "Voting Done Successfully");
	}
	else {
		model.addAttribute("Message", "You have Already Voted");
	}
		return "VoterPages/Login";
	}
	
	@PostMapping("/registeration")
	public String voterRegisteration(Voter voter,Model model) {
		voter.setRoles(Roles.VOTER);
		String msg=impl.insertInfo(voter);
		entity.setEmail(voter.getEmail());
		entity.setPassword(voter.getPassword());
		entity.setRole(voter.getRoles().toString());
		loginServiceImpl.save(entity);
		model.addAttribute("Message", msg);
		return "VoterPages/Login";
	}
	
}
