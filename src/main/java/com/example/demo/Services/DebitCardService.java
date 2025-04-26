package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.DebitCard;
import com.example.demo.Repository.DebitCardRepository;

@Service
public class DebitCardService {

	@Autowired
	private DebitCardRepository debitrepo;

	public Optional<DebitCard> createcard(DebitCard debit) {
		return Optional.of(debitrepo.save(debit));
	}
	
	
}
