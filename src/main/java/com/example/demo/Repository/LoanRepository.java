package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Loans;

public interface LoanRepository extends JpaRepository<Loans,Integer>{

	List<Loans> findByAccountNo(String accountNo);
	

}
