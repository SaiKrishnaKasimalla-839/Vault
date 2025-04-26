package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Investment;

public interface InvestmentRepository extends JpaRepository<Investment,Integer>{

	List<Investment> findByAccountNo(String accountNo);

}
