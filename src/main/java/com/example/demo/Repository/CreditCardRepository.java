package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard,Integer>{

	List<CreditCard> findByAccountNo(String accountNo);

}
