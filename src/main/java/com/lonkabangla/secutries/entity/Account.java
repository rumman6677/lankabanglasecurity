package com.lonkabangla.secutries.entity;

import com.lonkabangla.secutries.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNum;
    private String boNo;
    private String productType;
    private  String name;
    private String contact;
    private Date accountDate;
    private String accountType;
    private String clientCode;
    private String linkCode;
    @ManyToOne
    @JoinColumn(name = "account_holder_id")
    private AccountHolder accountHolder;

    @OneToOne
    @JoinColumn(name = "b_id",referencedColumnName = "id")
    private BankAccountDetails bankAccountDetails;

    @OneToOne
    @JoinColumn(name = "p_id",referencedColumnName = "id")
    private ImageEntity photo;

    @OneToOne
    @JoinColumn(name = "u_id",referencedColumnName = "id")
    private ImageEntity utilityBill;

    @OneToOne
    @JoinColumn(name = "nid_id",referencedColumnName = "id")
    private ImageEntity nid;

    @OneToOne
    @JoinColumn(name = "e_tin",referencedColumnName = "id")
    private ImageEntity etin;



    @Enumerated(EnumType.STRING)
    private Status status;

    private int year;

    public ImageEntity getUtilityBill() {
        return utilityBill;
    }

    public void setUtilityBill(ImageEntity utilityBill) {
        this.utilityBill = utilityBill;
    }

    public ImageEntity getNid() {
        return nid;
    }

    public void setNid(ImageEntity nid) {
        this.nid = nid;
    }

    public ImageEntity getEtin() {
        return etin;
    }

    public void setEtin(ImageEntity etin) {
        this.etin = etin;
    }

    public String getBranchNameOflSl() {
        return branchNameOflSl;
    }

    public void setBranchNameOflSl(String branchNameOflSl) {
        this.branchNameOflSl = branchNameOflSl;
    }

    private String branchNameOflSl;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ImageEntity getPhoto() {
        return photo;
    }

    public void setPhoto(ImageEntity photo) {
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    public BankAccountDetails getBankAccountDetails() {
        return bankAccountDetails;
    }

    public void setBankAccountDetails(BankAccountDetails bankAccountDetails) {
        this.bankAccountDetails = bankAccountDetails;
    }
}
