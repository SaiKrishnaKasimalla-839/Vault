package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance,Integer>{

	List<Insurance> findByAccountNo(String accountNo);

}
