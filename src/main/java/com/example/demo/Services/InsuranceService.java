package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Insurance;
import com.example.demo.Repository.InsuranceRepository;

@Service
public class InsuranceService {
@Autowired
private InsuranceRepository insrurancerepo;

public Optional<Insurance> takeInsurance(Insurance insurances) {
	
	return  Optional.of(insrurancerepo.save(insurances));
}

	
}
