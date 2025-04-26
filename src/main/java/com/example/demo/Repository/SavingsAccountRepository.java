package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.SavingsAccount;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount,Integer>{

}
