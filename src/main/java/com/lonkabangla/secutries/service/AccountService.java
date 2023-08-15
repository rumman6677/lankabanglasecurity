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

import java.time.LocalDate;
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

    public Account save(AccountDto accountDto) {
        Account account = prepareAccount(accountDto);
        AccountHolder accountHolder = getAccountHolder(accountDto);
        accountHolderRepo.save(accountHolder);
        account.setAccountHolder(accountHolder);
        BankAccountDetails bankAccountDetails = getBankAccount(accountDto);
        bankDetailsRepo.save(bankAccountDetails);
        account.setBankAccountDetails(bankAccountDetails);
        return accountRepository.save(account);

    }

    private BankAccountDetails getBankAccount(AccountDto accountDto) {
        BankAccountDetails bank = new BankAccountDetails();
        bank.setAccountNo(accountDto.getBaccountnumber());
        bank.setBankName(accountDto.getBankName());
        bank.setBranchName(accountDto.getBranchName());
        bank.setBankName(accountDto.getBankName());
        bank.setRoutingNo(accountDto.getRouteNo());
        return bank;
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
        account.setProductType(accountDto.getProductType());
        account.setStatus(Status.CHECK);
        LocalDate currentDate = LocalDate.now();
        account.setYear(currentDate.getYear());
        account.setBranchNameOflSl(accountDto.getLslbranchName());

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

    public Long updateStatus(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            Account newAccount = account.get();
            newAccount.setStatus(Status.REVIEW);
            accountRepository.save(newAccount);
            return account.get().getId();
        }
        return null;
    }

    public List<AccountDto> getReviewAccountList() {
        List<Account> accountList = accountRepository.findByStatus(Status.REVIEW);

        return accountList.stream().map(AccountDto::form).toList();
    }

    public List<AccountDto> getCheckAccountList() {
        List<Account> accountList = accountRepository.findByStatus(Status.CHECK);

        return accountList.stream().map(AccountDto::form).toList();
    }

    public Long activedUser(Long id) {

        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            Account newAccount = account.get();
            newAccount.setStatus(Status.ACTIVE);
            accountRepository.save(newAccount);
            return account.get().getId();
        }
        return null;
    }

    public List<AccountDto> allActiveUser() {
        List<Account> account = accountRepository.findAll();
        return account.stream().map(AccountDto::form).toList();

    }
}
