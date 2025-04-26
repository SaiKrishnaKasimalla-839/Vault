package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Customer;
import com.example.demo.Models.MainLoginDto;
import com.example.demo.Models.upiloginrequestdto;
import com.example.demo.Models.upiprofile;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.upirepository;

@Service
public class upiservice {

  

	@Autowired
	private upirepository upirepo;

    @Autowired
    private CustomerRepository customerrepo;

	public Optional<upiprofile> setupiprofile(upiprofile upi) {
		
		return Optional.of(upirepo.save(upi));
	}

	public Optional<upiprofile> unlockProfile(String setlockpin) {
	    List<upiprofile> upiList = upirepo.findAll();
	    
	    for (upiprofile upi : upiList) {
	        if (upi.getSetlockpin().equals(setlockpin)) {
	        	return Optional.of(upi);
	        }
	    }

	    System.out.println("Profile not found");
	    return null;
	}

	

	public Optional<upiloginrequestdto> checkBalance(String accountNo) {
	    Customer profile=customerrepo.findByAccountNo(accountNo);

	    if (profile != null) {
	        upiloginrequestdto dto = new upiloginrequestdto();
	        dto.setBalance(profile.getAccountBalance());
	        return Optional.of(dto);
	    }

	    return null;
	}

	//important
	public String upiLogin(MainLoginDto loginRequest) {
	    upiprofile upi = upirepo.findByAccountNo(loginRequest.getAccountNo());
	    if (upi == null) {
	        return "Invalid Credentials";
	    }
	    boolean accountMatches = loginRequest.getAccountNo().equals(upi.getAccountNo());
	    boolean mobileMatches  = loginRequest.getMobilenumber().equals(upi.getMobilenumber());

	    if (accountMatches && mobileMatches) {
	        return "Successful";
	    } else {
	        return "Invalid Credentials";
	    }
	}



	

	
}
