package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Models.CreditCard;
import com.example.demo.Models.Customer;
import com.example.demo.Models.DebitCard;
import com.example.demo.Models.Insurance;
import com.example.demo.Models.Investment;
import com.example.demo.Models.Loans;
import com.example.demo.Models.MainLoginDto;
import com.example.demo.Repository.CreditCardRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.DebitCardRepository;
import com.example.demo.Repository.InsuranceRepository;
import com.example.demo.Repository.InvestmentRepository;
import com.example.demo.Repository.LoanRepository;
import com.example.demo.Repository.upirepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerrepo;
    
    @Autowired
    private CreditCardRepository creditrepo;
    
    @Autowired
    private DebitCardRepository debitrepo;
    
    @Autowired
    private InsuranceRepository insurancerepo;
    
    @Autowired
    private LoanRepository loanrepo;
    
    @Autowired
    private InvestmentRepository investrepo;
    
//    @Autowired 
//    private upirepository upirepo;

    public Optional<Customer> addCustomer(Customer customer) {
        return Optional.of(customerrepo.save(customer));
    }

	public Optional<List<Customer>> getAllCustomers() {
		
		return Optional.of(customerrepo.findAll());
	}

	public Optional<Customer> fetch(String email, String password) {
	    List<Customer> customers = customerrepo.findAll();
	    for (Customer customer : customers) {
	        if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
	            return Optional.of(customer); 
	        }
	    }
	    return null;
	}

	public Optional<Customer> addMoney(String accountNo, double creditAmount) {
	    Customer customer = customerrepo.findByAccountNo(accountNo);
	    if (customer != null) {
	        double updatedBalance = customer.getAccountBalance() + creditAmount;  
	        customer.setAccountBalance(updatedBalance); 
	        return Optional.of(customerrepo.save(customer));  
	    } else {
	        throw new RuntimeException("Account not found with account number: " + accountNo);
	    }
	}


	public Optional<Customer> debitMoney(String accountNo, double debitAmount) {
		
		Customer customer=customerrepo.findByAccountNo(accountNo);
		if(customer!=null) {
			double updatebalance=customer.getAccountBalance()-debitAmount;
			customer.setAccountBalance(updatebalance);
			return Optional.of(customerrepo.save(customer));
		}
		else {
			throw new RuntimeException("Account Not Found With Account Number:"+accountNo);
		}
	
	}

	public Customer bankbalance(String accountNo) {
		Customer customer=customerrepo.findByAccountNo(accountNo);
		if(customer!=null) {
			double balance=customer.getAccountBalance();
			customer.setAccountBalance(balance);
			return customerrepo.save(customer);
		}
		return null;
	}

	public String setTransaction(String senderAccount, double senderAmount, String receiverAccount) {
	    Optional<Customer> senderOpt = Optional.ofNullable(customerrepo.findByAccountNo(senderAccount));
	    Optional<Customer> receiverOpt = Optional.ofNullable(customerrepo.findByAccountNo(receiverAccount));

	    if (!senderOpt.isPresent() || !receiverOpt.isPresent()) {
	        throw new RuntimeException("Sender or Receiver account not found");
	    }

	    Customer sender = senderOpt.get();
	    Customer receiver = receiverOpt.get();

	    if (sender.getAccountBalance() < senderAmount) {
	        throw new RuntimeException("Insufficient balance in sender's account");
	    }

	    sender.setAccountBalance(sender.getAccountBalance() - senderAmount);
	    receiver.setAccountBalance(receiver.getAccountBalance() + senderAmount);

	    customerrepo.save(sender);
	    customerrepo.save(receiver);

	    return "Transaction successful: ₹" + senderAmount + " sent from " +
	            senderAccount + " to " + receiverAccount;
	}

	public Optional<MainLoginDto> createProfile(String name, String accountNo) {
	    Customer customer = customerrepo.findByAccountNo(accountNo);
	    
	    if (customer != null) {
	        MainLoginDto profile = new MainLoginDto();
	        profile.setName(customer.getCustomerName());
	        profile.setAccountNo(accountNo);
	        List<CreditCard> creditCards = creditrepo.findByAccountNo(accountNo);
	        List<DebitCard> debitCards = debitrepo.findByAccountNo(accountNo);
	        List<Insurance> insurances = insurancerepo.findByAccountNo(accountNo);
	        List<Investment> investments = investrepo.findByAccountNo(accountNo);
	        List<Loans> loans = loanrepo.findByAccountNo(accountNo);
	        profile.setCreditCards(creditCards);
	        profile.setDebitCards(debitCards);
	        profile.setInsurances(insurances);
	        profile.setInvestments(investments);
	        profile.setLoans(loans);
	        return Optional.of(profile);
	    }
	    return null;
	}


	
	
	
	

	

	
	
	

}
