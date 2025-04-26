package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.CreditCard;
import com.example.demo.Repository.CreditCardRepository;

@Service
public class CreditCardService {
@Autowired
private CreditCardRepository creditcardrepo;

public Optional<CreditCard> createCard(CreditCard credit) {
	
	return Optional.of(creditcardrepo.save(credit));
}

}
