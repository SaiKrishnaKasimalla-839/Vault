package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.ExceptionHandling.ResourceNotFoundException;
import com.example.demo.Models.*;
import com.example.demo.Services.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Bankapp")
public class Application {

    @Autowired
    private CustomerService customerservice;

    @Autowired
    private LoansService loansservice;

    @Autowired
    private DebitCardService debitservice;

    @Autowired
    private InsuranceService insuranceservice;

    @Autowired
    private InvestmentService investmentservice;

    @Autowired
    private SavingsAccountService accountservice;

    @Autowired
    private upiservice upiService;

    @Autowired
    private CreditCardService creditcardservice;

    @PostMapping("/createcustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerservice.addCustomer(customer)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to create customer: " + customer));//.getName()));
    }

    @GetMapping("/customerprofile")
    public List<Customer> getAllCustomers() {
        return customerservice.getAllCustomers()
                .orElseThrow(() -> new ResourceNotFoundException("No customer profiles found"));
    }

    @PostMapping("/fetchprofile")
    public Customer fetchById(@RequestBody customerlogin login) {
        return customerservice.fetch(login.getEmail(), login.getPassword())
                .orElseThrow(() -> new ResourceNotFoundException("Login failed for email: " + login.getEmail()));
    }

    @PostMapping("/loans")
    public Loans takeloans(@RequestBody Loans loan) {
        return loansservice.takeLoans(loan)
                .orElseThrow(() -> new ResourceNotFoundException("Loan creation failed for: " + loan.getLoanType()));
    }

    @PostMapping("/debitcard")
    public DebitCard createDebitCard(@RequestBody DebitCard debit) {
        return debitservice.createcard(debit)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to create debit card for account: " + debit.getAccountNo()));
    }

    @PostMapping("/savingsaccount")
    public SavingsAccount createSavingsAccount(@RequestBody SavingsAccount savings) {
        return accountservice.createSavingaccount(savings)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to create savings account for: " )); //savings.getAccountNo()));
    }

    @PostMapping("/insurance")
    public Insurance takeInsurance(@RequestBody Insurance insurance) {
        return insuranceservice.takeInsurance(insurance)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to create insurance for: " + insurance.getAccountNo()));
    }

    @PostMapping("/investments")
    public Investment makeInvestment(@RequestBody Investment investment) {
        return investmentservice.makeInvestment(investment)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to create investment for: " + investment.getAccountNo()));
    }

    @PostMapping("/credit")
    public Customer creditMoney(@RequestBody Customer credit) {
        return customerservice.addMoney(credit.getAccountNo(), credit.getAccountBalance())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for crediting: " + credit.getAccountNo()));
    }

    @PostMapping("/debit")
    public Customer debitMoney(@RequestBody Customer debit) {
        return customerservice.debitMoney(debit.getAccountNo(), debit.getAccountBalance())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for debiting: " + debit.getAccountNo()));
    }

    @PostMapping("/transaction")
    public String sendMoney(@RequestBody TransactionDto transaction) {
        return customerservice.setTransaction(
                transaction.getSenderAccount(),
                transaction.getAmount(),
                transaction.getReceiverAccount()
        );
    }

    @PostMapping("/upi")
    public upiprofile createUpiProfile(@RequestBody upiprofile upi) {
        return upiService.setupiprofile(upi)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to create UPI profile for: " + upi));
    }

    @PostMapping("/unlock")
    public upiprofile unlockUpiProfile(@RequestBody upiprofile upi) {
        return upiService.unlockProfile(upi.getSetlockpin())
                .orElseThrow(() -> new ResourceNotFoundException("Failed to unlock UPI profile with PIN: " + upi.getSetlockpin()));
    }

    @PostMapping("/upilogin")
    public String loginUpi(@RequestBody MainLoginDto loginRequest) {
        return upiService.upiLogin(loginRequest);
    }

    @PostMapping("/checkbalance")
    public upiloginrequestdto balance(@RequestBody upiloginrequestdto balance) {
        return upiService.checkBalance(balance.getAccountNo())
                .orElseThrow(() -> new ResourceNotFoundException("Failed to fetch balance for account: " + balance.getAccountNo()));
    }

    @PostMapping("/creditcard")
    public CreditCard createCreditCard(@RequestBody CreditCard credit) {
        return creditcardservice.createCard(credit)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to create credit card for: " + credit.getAccountNo()));
    }

    @PostMapping("/mainprofile")
    public MainLoginDto createMainProfile(@RequestBody MainLoginDto main) {
        return customerservice.createProfile(main.getName(), main.getAccountNo())
                .orElseThrow(() -> new ResourceNotFoundException("Main profile creation failed for: " + main.getAccountNo()));
    }
}
