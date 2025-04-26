package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Loans;
import com.example.demo.Repository.LoanRepository;

@Service
public class LoansService {

	@Autowired 
	private LoanRepository loansrepo;

	public Optional<Loans> takeLoans(Loans loan) {
		
		return Optional.of(loansrepo.save(loan));
	}
	
	
}
