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
	    Customer customer = customerrepo.findByAccountNo(loginRequest.getAccountNo());

	    if (customer != null) {
	        System.out.println("Found upi profile: " + customer);
	        System.out.println("Login request accountNo: " + loginRequest.getAccountNo());
//	        System.out.println("Login request mobilenumber: " + loginRequest.getMobilenumber());
	    } else {
	        System.out.println("No profile found for accountNo: " + loginRequest.getAccountNo());
	    }

	    if (customer == null) {
	        return "Invalid Credentials";
	    }

	    boolean accountMatches = loginRequest.getAccountNo().equals(customer.getAccountNo());
	    //boolean mobileMatches  = loginRequest.getMobilenumber().equals(customer.getMobileNo());

	    if (accountMatches) {
	        return "Successful";
	    } else {
	        return "Invalid Credentials";
	    }
	}




	

	
}
