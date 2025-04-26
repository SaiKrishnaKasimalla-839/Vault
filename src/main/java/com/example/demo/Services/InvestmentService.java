package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Investment;
import com.example.demo.Repository.InvestmentRepository;

@Service
public class InvestmentService {
@Autowired
private InvestmentRepository investrepo;

public Optional<Investment> makeInvestment(Investment investment) {
	
	return Optional.of(investrepo.save(investment));
}
}
