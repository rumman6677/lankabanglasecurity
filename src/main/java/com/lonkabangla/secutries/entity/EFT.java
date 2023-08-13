package com.lonkabangla.secutries.entity;

import com.lonkabangla.secutries.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EFT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clintCode;
    private Date date;
    private String clientName;
    private String mobileNumber;

    @OneToOne
    @JoinColumn(columnDefinition = "b_id", referencedColumnName = "id")
    private BankAccountDetails bankAccountDetails;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status;

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

    public BankAccountDetails getBankAccountDetails() {
        return bankAccountDetails;
    }

    public void setBankAccountDetails(BankAccountDetails bankAccountDetails) {
        this.bankAccountDetails = bankAccountDetails;
    }
}
