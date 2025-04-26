package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.upiprofile;

@Repository
public interface upirepository extends JpaRepository<upiprofile,Integer>{
	upiprofile findByAccountNo(String accountno);

}


