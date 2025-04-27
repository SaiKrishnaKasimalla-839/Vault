package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Passbook;

public interface PassbookRepository extends JpaRepository<Passbook,Integer> {
List<Passbook> findBySenderAccount(String senderAccount);
}
