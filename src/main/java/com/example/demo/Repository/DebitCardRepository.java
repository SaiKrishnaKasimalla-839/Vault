package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.DebitCard;

public interface DebitCardRepository extends JpaRepository<DebitCard,Integer>{

	

	List<DebitCard> findByAccountNo(String accountNo);

}
