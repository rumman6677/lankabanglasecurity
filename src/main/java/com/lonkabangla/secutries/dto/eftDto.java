package com.lonkabangla.secutries.dto;

import com.lonkabangla.secutries.entity.EFT;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class eftDto {

    private Long id;
    private String clintCode;
    private Date date;
    private String clientName;
    private String mobileNumber;
    private String bankName;
    private String branchName;
    private String  accountNo;
    private String routingNo;

    public static  eftDto form(EFT eft){
        eftDto eft1= new eftDto();
        eft1.setClintCode(eft.getClintCode());
        eft1.setDate(eft.getDate());
        eft1.setClientName(eft.getClientName());
        eft1.setMobileNumber(eft.getMobileNumber());
        eft1.setBankName(eft.getBankAccountDetails().getBankName());
        eft1.setBranchName(eft.getBankAccountDetails().getBranchName());
        eft1.setAccountNo(eft.getBankAccountDetails().getAccountNo());
        eft1.setRoutingNo(eft.getBankAccountDetails().getRoutingNo());
        return eft1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClintCode() {
        return clintCode;
    }

    public void setClintCode(String clintCode) {
        this.clintCode = clintCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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
