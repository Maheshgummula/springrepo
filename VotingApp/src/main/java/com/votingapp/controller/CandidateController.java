package com.votingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.votingapp.model.Candidate;
import com.votingapp.service.CandidateServiceImpl;

@Controller
public class CandidateController {
	@Autowired
	CandidateServiceImpl impl;

	@PostMapping("admin/addCandidate")
	public String addCandidates(@ModelAttribute Candidate candidate,Model model) {
		impl.addCandidates(candidate);
		model.addAttribute("Message", "Candidate Added Successfully!");
		return "VoterPages/AdminHomePage";
	}
	
	
	
	@GetMapping("voter/getAllCandidates")
	public String getAllCandidates(Model model) {
		List<Candidate> candidates=impl.getAllCandidates();
		model.addAttribute("CandidatesList", candidates);
		return "VoterPages/VotingPage";
	}
	
	
}
