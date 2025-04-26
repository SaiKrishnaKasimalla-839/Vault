package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.SavingsAccount;
import com.example.demo.Repository.SavingsAccountRepository;

@Service
public class SavingsAccountService {
@Autowired
private SavingsAccountRepository savingsrepo;

public Optional<SavingsAccount> createSavingaccount(SavingsAccount savings) {
	
	return Optional.of(savingsrepo.save(savings));
}

}
