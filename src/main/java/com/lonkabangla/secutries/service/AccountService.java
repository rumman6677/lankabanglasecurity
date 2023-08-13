package com.lonkabangla.secutries.service;

import com.lonkabangla.secutries.Enum.Status;
import com.lonkabangla.secutries.dto.AccountDto;
import com.lonkabangla.secutries.entity.Account;
import com.lonkabangla.secutries.entity.AccountHolder;
import com.lonkabangla.secutries.entity.BankAccountDetails;
import com.lonkabangla.secutries.repository.AccountHolderRepo;
import com.lonkabangla.secutries.repository.AccountRepository;
import com.lonkabangla.secutries.repository.BankDetailsRepo;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountHolderRepo accountHolderRepo;

    private final BankDetailsRepo bankDetailsRepo;

    public AccountService(AccountRepository accountRepository, AccountHolderRepo accountHolderRepo, BankDetailsRepo bankDetailsRepo) {
        this.accountRepository = accountRepository;
        this.accountHolderRepo = accountHolderRepo;
        this.bankDetailsRepo = bankDetailsRepo;
    }

    public void save(AccountDto accountDto) {
        Account account = prepareAccount(accountDto);
        AccountHolder accountHolder = getAccountHolder(accountDto);
        accountHolderRepo.save(accountHolder);
        account.setAccountHolder(accountHolder);
        BankAccountDetails bankAccountDetails = getBankAccount(accountDto);
        bankDetailsRepo.save(bankAccountDetails);
        account.setBankAccountDetails(bankAccountDetails);
        accountRepository.save(account);

    }

    private BankAccountDetails getBankAccount(AccountDto accountDto) {
        BankAccountDetails bank = new BankAccountDetails();
        bank.setAccountNo(accountDto.getAccountNo());
        bank.setBankName(accountDto.getBankName());
        bank.setBranchName(accountDto.getBranchName());
        bank.setBankName(accountDto.getBankName());
        bank.setRoutingNo(accountDto.getRoutingNo());
        return  bank;
    }

    private Account prepareAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setName(accountDto.getName());
        account.setBoNo(accountDto.getBoNo());
        account.setName(accountDto.getBoNo());
        account.setContact(accountDto.getContact());
        account.setAccountDate(accountDto.getAccountDate());
        account.setAccountType(accountDto.getAccountType());
        account.setClientCode(accountDto.getClientCode());
        account.setLinkCode(accountDto.getLinkCode());
        account.setStatus(Status.REVIEW);

        return account;
    }

    private AccountHolder getAccountHolder(AccountDto accountDto) {
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setName(accountDto.getAccountHolderName());
        accountHolder.setFatherName(accountDto.getFatherName());
        accountHolder.setMotherName(accountDto.getMotherName());
        accountHolder.setDateOfBirth(accountDto.getDateOfBirth());
        accountHolder.setGender(accountDto.getGender());
        accountHolder.setNationality(accountDto.getNationality());
        accountHolder.setPrAddress(accountDto.getPrAddress());
        accountHolder.setPhoneNumber(accountDto.getPhoneNumber());
        accountHolder.setTel(accountDto.getTel());
        accountHolder.setpAddress(accountDto.getpAddress());
        accountHolder.setEmail(accountDto.getEmail());
        accountHolder.setOccupation(accountDto.getOccupation());
        return accountHolder;
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public List<AccountDto> findAllAccount() {

        List<Account> accounts = accountRepository.findAll();

        return accounts.stream().map(AccountDto::form).toList();
    }
}
