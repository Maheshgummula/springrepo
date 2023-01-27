package com.votingapp.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Candidate {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String CandidateName;
@OneToMany(targetEntity = Voter.class,mappedBy = "candidate")
Set<Voter> voters;
}
