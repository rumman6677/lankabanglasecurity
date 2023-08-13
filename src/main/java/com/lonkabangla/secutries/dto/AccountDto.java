package com.lonkabangla.secutries.dto;

import com.lonkabangla.secutries.entity.Account;
import com.lonkabangla.secutries.entity.AccountHolder;
import com.lonkabangla.secutries.entity.BankAccountDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountNum;
    private String boNo;
    private String productType;
    private String name;
    private String contact;
    private Date accountDate;
    private String accountType;
    private String clientCode;
    private String linkCode;
    private String accountHolderName;
    private String fatherName;
    private String motherName;
    private Date dateOfBirth;
    private String gender;
    private String nationality;
    private String prAddress;
    private String phoneNumber;
    private String tel;
    private String pAddress;
    private String email;
    private String occupation;
    private String eTin;
    private String bankName;
    private String branchName;
    private String accountNo;
    private String routingNo;

    private String branchNameLSL;

    private Long photoId;
    public static AccountDto form(Account account) {
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setAccountNum(account.getAccountNum());
        dto.setBoNo(account.getBoNo());
        dto.setProductType(account.getProductType());
        dto.setName(account.getName());
        dto.setContact(account.getContact());
        dto.setAccountDate(account.getAccountDate());
        dto.setAccountType(account.getAccountType());
        dto.setClientCode(account.getClientCode());
        dto.setLinkCode(account.getLinkCode());
        AccountHolder accountHolder = account.getAccountHolder();
        dto.setAccountHolderName(accountHolder.getName());
        dto.setFatherName(accountHolder.getFatherName());
        dto.setMotherName(accountHolder.getMotherName());
        dto.setDateOfBirth(accountHolder.getDateOfBirth());
        dto.setGender(accountHolder.getGender());
        dto.setNationality(accountHolder.getNationality());
        dto.setPrAddress(accountHolder.getPrAddress());
        dto.setPhoneNumber(accountHolder.getPhoneNumber());
        dto.setTel(accountHolder.getTel());
        dto.setpAddress(accountHolder.getpAddress());
        dto.setEmail(accountHolder.getEmail());
        dto.setOccupation(accountHolder.getOccupation());
        dto.seteTin(accountHolder.geteTin());
        BankAccountDetails bank = account.getBankAccountDetails();
        dto.setBankName(bank.getBankName());
        dto.setBranchName(bank.getBranchName());
        dto.setAccountNo(bank.getAccountNo());
        dto.setRoutingNo(bank.getRoutingNo());
        dto.setPhotoId(account.getPhoto()==null ? null:account.getPhoto().getId() );

        return dto;
    }

    public String getBranchNameLSL() {
        return branchNameLSL;
    }

    public void setBranchNameLSL(String branchNameLSL) {
        this.branchNameLSL = branchNameLSL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getBoNo() {
        return boNo;
    }

    public void setBoNo(String boNo) {
        this.boNo = boNo;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getLinkCode() {
        return linkCode;
    }

    public void setLinkCode(String linkCode) {
        this.linkCode = linkCode;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPrAddress() {
        return prAddress;
    }

    public void setPrAddress(String prAddress) {
        this.prAddress = prAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String geteTin() {
        return eTin;
    }

    public void seteTin(String eTin) {
        this.eTin = eTin;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getRoutingNo() {
        return routingNo;
    }

    public void setRoutingNo(String routingNo) {
        this.routingNo = routingNo;
    }
}
