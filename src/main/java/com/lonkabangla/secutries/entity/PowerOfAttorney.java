package com.lonkabangla.secutries.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PowerOfAttorney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cdblId;
    private String boId;
    private String name;

    private String poaName;

    private String shortName;

    @OneToOne
    @JoinColumn(columnDefinition = "a_id",referencedColumnName = "id")
    private Address poaAddress;

    @OneToOne
    @JoinColumn(columnDefinition = "p_id",referencedColumnName = "id")
    private PassPort passPort;

    private String startDate;

    private String endDate;

    private String dob;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCdblId() {
        return cdblId;
    }

    public void setCdblId(String cdblId) {
        this.cdblId = cdblId;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoaName() {
        return poaName;
    }

    public void setPoaName(String poaName) {
        this.poaName = poaName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Address getPoaAddress() {
        return poaAddress;
    }

    public void setPoaAddress(Address poaAddress) {
        this.poaAddress = poaAddress;
    }

    public PassPort getPassPort() {
        return passPort;
    }

    public void setPassPort(PassPort passPort) {
        this.passPort = passPort;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
